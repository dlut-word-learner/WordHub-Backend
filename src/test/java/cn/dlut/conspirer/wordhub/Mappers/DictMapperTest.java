package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Dtos.WordToReviewDTO;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Vos.WordExtensionVo;
import cn.dlut.conspirer.wordhub.Vos.WordToReviewVo;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@MybatisTest
@ContextConfiguration(classes = WordHubApplication.class)
@Rollback(value = true)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DictMapperTest {
    @Autowired
    DictMapper dictMapper;

    @Test
    @Sql("/data-testGetWordsByDictId.sql")
    void testGetWordsByDictId() {
        List<Word> wordList = dictMapper.getWordsByDictId(1001L);
        assertFalse(wordList.isEmpty());
        JsonNode extension;
        try {
            extension = new ObjectMapper().readTree("{\"ukphone\": \"uk\", \"usphone\": \"us\", \"trans\": [\"trans1\",\"trans2\"]}");
            // log.info(extension.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Word word1 =
                Word.builder().id(101L).name("word1").dictId(1001L).extension(extension).build();
        assertThat(wordList).hasSize(6).contains(word1);
    }

    @Test
    @Sql("/data-testGetLanguageByDictId.sql")
    void testGetLanguageByDictId() {
        Languages id = dictMapper.getLanguageByDictId(101L);
        Languages test = Languages.Test;
        assertEquals(test, id);
    }

    @Test
    @Sql("/data-testGetDictByName.sql")
    void testGetDictByName() {
        Dict dict = dictMapper.getDictByName("NameTest");
        Languages testLanguages = Languages.Test;
        Dict test = new Dict(1003L, testLanguages, "NameTest");
        assertEquals(test, dict);
    }


    @Test
    @Sql("/data-testGetDictById.sql")
    void testGetDictById() {
        Dict dict = dictMapper.getDictById(1002L);
        Languages testLanguages = Languages.Test;
        List<Word> wordListTest = null;
        Dict test = new Dict(1002L, testLanguages, "Test");
        assertEquals(test, dict);

    }

    @Test
    @Sql("/data-testGetDicts.sql")
    void testGetDicts() {
        List<Dict> testDict = dictMapper.getDicts();
        assertNotNull(testDict);
        String DictName = "DictTest";
        Languages testLanguages = Languages.Test;
        Dict dict = new Dict(1010L, testLanguages, DictName);
        assertThat(testDict).contains(dict);
    }

    @Test
    @Sql("/data-testGetWordsToLearn.sql")
    void testGetWordsToLearn() {
        List<Word> wordList = dictMapper.getWordsToLearn(1005L, 1L, 3L);
        log.info(wordList.toString());
        assertThat(wordList).extracting(Word::getName).containsExactlyInAnyOrder("word5", "word4");
        wordList = dictMapper.getWordsToLearn(1005L, 1L, 1L);
        assertThat(wordList).extracting(Word::getName).containsAnyOf("word5",
                "word4");
    }

    @Test
    @Sql("/data-testGetWordsToReview.sql")
    void testGetWordsToReview() {
        ObjectMapper objectMapper = new ObjectMapper();
        WordToReviewVo study_rec =
                WordToReviewVo.builder().id(101L).tick(1L).name("word1").extension(new WordExtensionVo()).build();
        List<WordToReviewVo> testWordToReview = dictMapper.getWordsToReview(1005L,1L,3L).stream().map(x -> {
            WordToReviewVo word =
                    null;
            try {
                word = WordToReviewVo.builder().tick(x.getTick()).id(x.getId()).name(x.getName()).extension(objectMapper.treeToValue(x.getExtension(), WordExtensionVo.class)).build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return word;
        }).collect(Collectors.toList()); ;

        assertThat(testWordToReview).contains(study_rec);

    }

    @Test
    @Sql("/data-testGetMasteredNum.sql")
    void testGetMasteredNum(){
        long testDictId = 1005 , testUserId = 1;
        long Num = dictMapper.getNumMastered(testDictId,testUserId);
        assertEquals(2,Num);
    }

    @Test
    @Sql("/data-testGetMasteredNum.sql")
    void testGetNumUnMastered(){
        long testDictId = 1005 , testUserId = 1;
        long Num = dictMapper.getNumUnmastered(testDictId,testUserId);
        assertEquals(1,Num);
    }

    @Test
    @Sql("/data-testGetMasteredNum.sql")
    void testGetWordNum(){
        long testDictId = 1005;
        long WordNum = dictMapper.getWordNum(testDictId);
        assertEquals(6,WordNum);
    }







    /*
     * TODO

    @Test
    @Sql("/data-testGetLearnTickInPastNDays.sql")
    void testGetLearnTickInPastNDays(){
        long userID = 1, n = 3;
        long Num = dictMapper.getLearnTickInPastNDays(DictId,userID,n);
        assertEquals(2,Num);
    }

    @Test
    @Sql("/data-testGetReviewTickInPastNDays.sql")
    void testGetReviewTickInPastNDays(){
        long userID = 1, n = 6;
      //  long Num = dictMapper.getReviewTickInPastNDays(DictId,userID,n);
       //  assertEquals(5,Num);
    }

    /*

    @Test
    @Sql
    void testGetQwertiyTickInPastNDays(){
    }



    @Test
    @Sql
    void testInsertQwertyRec(){
    }


     */



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