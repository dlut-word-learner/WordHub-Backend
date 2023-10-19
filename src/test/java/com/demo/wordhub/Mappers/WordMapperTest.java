package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.Word;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class WordMapperTest {
    @Autowired
    WordMapper wordMapper;

    @Test
    void testGetTrans(){
        Word w = new Word();
        w.setName("test");
        w.setDictId(0L);
        w.setTranslations(Arrays.stream(new String[]{"When you test something, you test something(", "test是测试的意思"}).toList());

        int lines = wordMapper.addWord(w);
        Long id = w.getId();

        assertEquals(lines, 1);

        w.getTranslations().forEach(x -> wordMapper.addTransForWord(w, x));
        assertEquals(wordMapper.getTranslationsByWordId(w.getId()).size(), 2);
    }
}