package cn.dlut.conspirer.wordhub;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Services.DictService;
import cn.dlut.conspirer.wordhub.Services.WordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

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
    @Transactional
    public void run(String... args) throws Exception {
        log.info("WordHubDictImporter启动");
        Arrays.stream(args).forEach(log::info);
        String filePath, dictName;
        Languages lang;
        if(args.length<3){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input the language of the dict(English or Japanese): ");
            lang = Languages.valueOf(scanner.nextLine());
            System.out.println("Input the name of the dict: ");
            dictName = scanner.nextLine();
            System.out.println("Input the path of the dict: ");
            filePath = scanner.nextLine();
        }
        else {
            filePath = args[0];
            dictName = args[1];
            lang = Languages.valueOf(args[2]);
        }

        File dictFile = new File(filePath);
        JsonNode words = objectMapper.readTree(dictFile);

        Dict dict = new Dict(lang, dictName);
        dictService.addDict(dict);
        words.elements().forEachRemaining(x -> {
            try {
                ObjectNode objectNode = (ObjectNode) x;
                log.info("ori:" + objectNode.toString());
                ObjectNode extension = objectMapper.createObjectNode();
                Iterator<Map.Entry<String, JsonNode>> fieldsIterator = objectNode.fields();
                while (fieldsIterator.hasNext()) {
                    Map.Entry<String, JsonNode> field = fieldsIterator.next();
                    if(!field.getKey().equals("name")){
                        if(field.getKey().equals("trans"))
                            extension.put("meanings", field.getValue());
                        else extension.put(field.getKey(), field.getValue());
                        fieldsIterator.remove();
                    }
                }
                objectNode.put("extension", extension);
                log.info("After: " + objectNode.toString());
                Word word = objectMapper.treeToValue(objectNode, Word.class);
                wordService.addWordToDict(dict.getId(), word);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
