package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Slf4j
class WordMapperTest {
    @Autowired
    WordMapper wordMapper;

    @Test
    void testAddWord(){
        JsonNode extension;
        try {
            extension = new ObjectMapper().readTree("{\"ukphone\": \"uk\", \"usphone\": \"us\"}");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Word testWord = new Word(100001L,"testWord",0L,extension);
        int lines = wordMapper.addWord(testWord);
        assertEquals(1,lines);
    }

    /**
     * TODO
     * where is wordtrans ?
     */
    @Test
    void testAddTransForword(){
        JsonNode extension;
        try {
            extension = new ObjectMapper().readTree("{\"ukphone\": \"uk\", \"usphone\": \"us\"}");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Word testWord = new Word(100002L,"testWord",0L,extension);
        String testTrans = "this is testTran" ;
      int lines =   wordMapper.addTransForWord(testWord,testTrans);
      assertEquals(1,lines);
    }

//    @Test
//    void testGetTrans() {
//        Word w = new Word();
//        w.setName("test");
//        w.setDictId(0L);
//        w.setTranslations(Arrays.stream(new String[]{"When you test something, you test something(", "test是测试的意思"}).toList());
//
//        int lines = wordMapper.addWord(w);
//        Long id = w.getId();
//
//        assertEquals(lines, 1);
//
//        w.getTranslations().forEach(x -> wordMapper.addTransForWord(w, x));
//        assertEquals(wordMapper.getTranslationsByWordId(w.getId()).size(), 2);
//    }
}