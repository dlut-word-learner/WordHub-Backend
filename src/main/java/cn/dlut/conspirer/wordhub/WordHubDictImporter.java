package cn.dlut.conspirer.wordhub;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Services.DictService;
import cn.dlut.conspirer.wordhub.Services.WordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 用于向数据库导入json格式单词表的工具类
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class, EmbeddedWebServerFactoryCustomizerAutoConfiguration.class})
public class WordHubDictImporter implements CommandLineRunner {
    @Autowired
    DictService dictService;
    @Autowired
    WordService wordService;
    @Autowired
    ObjectMapper objectMapper;
    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        new SpringApplicationBuilder(WordHubDictImporter.class).web(WebApplicationType.NONE).run(args);
        log.info("APPLICATION FINISHED");
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("WordHubDictImporter启动");
        Arrays.stream(args).forEach(log::info);
        if(args.length<2)return ;
        File dictFile = new File(args[0]);
        String dictName = args[1];
        JsonNode words = objectMapper.readTree(dictFile);
        Languages lang = Languages.English;
        Dict dict = new Dict(lang, dictName);
        dictService.addDict(dict);
        words.elements().forEachRemaining(x -> {
            try {
                Word word = objectMapper.treeToValue(words, Word.class);
                wordService.addWordToDict(dict.getId(), word);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
