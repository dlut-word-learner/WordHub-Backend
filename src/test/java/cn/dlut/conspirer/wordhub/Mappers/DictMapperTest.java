package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
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
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DictMapperTest {
    @Autowired
    DictMapper dictMapper;

    @Test
    @Sql("/data-testGetWordsByDictId.sql")
    void testGetWordsByDictId(){
         List<Word> wordList = dictMapper.getWordsByDictId(1001L);
         assertFalse(wordList.isEmpty());
         JsonNode extension;
        try {
            extension = new ObjectMapper().readTree("{\"ukphone\": \"uk\", \"usphone\": \"us\"}");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Word word1 = Word.builder().id(101L).name("word1").dictId(1001L).extension(extension).build();
         assertThat(wordList).hasSize(6).contains(word1);
    }

    @Test
    @Sql("/data-testGetLanguageByDictId.sql")
    void testGetLanguageByDictId(){
        Languages id = dictMapper.getLanguageByDictId(101L);
        Languages test = Languages.Test;
        assertEquals(id,test);
    }

//    @Test
//    void getWordsByDictId() {
//        List<Word> wordList = dictMapper.getWordsByDictId(0L);
//        log.info(wordList.toString());
//        assertFalse(wordList.isEmpty());
//    }

//    @Test
//    void getLanguageIdByDictId() {
//        Long id = dictMapper.getLanguageIdByDictId(0L);
//        assertEquals(id, 0L);
//    }

//    @Test
//    void getDictByName() {
//        Dict dict = dictMapper.getDictByName("Test");
//        log.info(dict.toString());
//        assertNotNull(dict);
//    }

//    @Test
//    @Sql("/data-testGetWordsToLearn.sql")
//    void testGetWordsToLearn(){
//        List<Word > wordList = dictMapper.getWordsToLearn(1001L, 1L, 5L);
//
//        assertThat(wordList).extracting(Word::getName).containsExactlyInAnyOrder("word5","word6");
//
//        wordList = dictMapper.getWordsToLearn(1001L, 1L, 1L);
//
//        assertThat(wordList).extracting(Word::getName).containsAnyOf("word5","word6");
//    }

//    @Test
//    @Sql("/data-testGetMultiLanguageWords.sql")
//    void testGetMultiLanguageWords(){
//        List<Word> wordList = dictMapper.getWordsByDictId();
//        log.info();
//    }
}