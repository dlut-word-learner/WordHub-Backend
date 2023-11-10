package cn.dlut.conspirer.wordhub.Services;
import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.Impls.WordServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class WordServicesTest {
    @Mock
    WordMapper wordMapper;

    @InjectMocks
    private WordService wordService = new WordServiceImpl(wordMapper);

    @Test
    void addWordToDict(){
       long dictId = 101L ;
       String testWordName = "testName";
        JsonNode extension;
        try {
            extension = new ObjectMapper().readTree("{\"ukphone\": \"uk\", \"usphone\": \"us\", \"trans\": [\"trans1\",\"trans2\"]}");
            // log.info(extension.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Word word =
                Word.builder().id(101L).name(testWordName).dictId(101L).extension(extension).build();
        wordService.addWordToDict(dictId,word);
        verify(wordMapper).addWordToDict(dictId,word);
    }

    @Test
    void learnWord(){
        long userId = 101L, wordId = 101L;
        boolean familiar = true;
        wordService.learnWord(userId,wordId,familiar);
        verify(wordMapper).insertStudyRec(eq(userId),eq(wordId),any(),eq(1L),any(),any());
    }
    @Test
    void reviewWord_1(){
        long userId = 101L,wordId = 101L,tick = 1;
        SchedulingStates schedulingStates = SchedulingStates.Good;
        boolean result = true;
        result =  wordService.reviewWord(userId,wordId,schedulingStates,tick);
        verify(wordMapper).getLatestStudyRec(userId,wordId);
        assertFalse(result);
    }
    @Test
    void reviewWord_2(){
        when(wordMapper.getLatestStudyRec(1L, 101L)).thenReturn(new StudyRec(1L, 101L, 1L, 3L, 1., Timestamp.valueOf(
        "2023-11-01 10:01:04"), 1L));
        long userId = 1L,wordId = 101L,tick = 2;
        when(wordMapper.insertStudyRec(eq(userId),eq(wordId),any(),any(),any(),any())).thenReturn(1);
        SchedulingStates schedulingStates = SchedulingStates.Hard;
        boolean result = false;
        result = wordService.reviewWord(userId,wordId,schedulingStates,tick);
        verify(wordMapper).getLatestStudyRec(userId,wordId);
        verify(wordMapper).insertStudyRec(eq(userId),eq(wordId),any(),any(),any(),any());
        assertTrue(result);
    }




}
