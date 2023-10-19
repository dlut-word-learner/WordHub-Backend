package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Word;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DictMapperTest {
    @Autowired
    DictMapper dictMapper;

    @Test
    void getWordsByDictId() {
        List<Word> wordList = dictMapper.getWordsByDictId(0L);
        log.info(wordList.toString());
        assertFalse(wordList.isEmpty());
    }

    @Test
    void getLanguageIdByDictId() {
        Long id = dictMapper.getLanguageIdByDictId(0L);
        assertEquals(id, 0L);
    }

    @Test
    void getDictByName() {
        Dict dict = dictMapper.getDictByName("Test");
        log.info(dict.toString());
        assertNotNull(dict);
    }
}