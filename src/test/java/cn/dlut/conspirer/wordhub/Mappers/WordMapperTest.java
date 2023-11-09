package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.WordHubApplication;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@MybatisTest
@ContextConfiguration(classes = WordHubApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Slf4j
class WordMapperTest {
    @Autowired
    WordMapper wordMapper;
}