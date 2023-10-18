package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 网上说没这句可能导致无法成功注入，但实测是没问题的
//@RunWith(SpringRunner.class)
@MybatisTest
// MybatisTest默认使用内存（嵌入式）数据库，而不是真实数据库，所以需要手动配置这里来使用MySQL进行测试（会自动回滚）
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void getAll() {
        // when
        List<User> users = userMapper.getAll();

        // then
        assertFalse(users.isEmpty());
    }

    @Test
    void addUser() {
        // given
        User user = new User();
        user.setUsername("test_abc");
        user.setEmail("test@te.st");
        user.setPassword("Test123");

        // when
        int lines = userMapper.addUser(user);

        // then
        assertEquals(1, lines);
        assertNotNull(user.getId());
    }

    @Test
    void getUserByIdWhenNotExists() {
        // when
        User user = userMapper.getUserById(123L);

        // then
        assertNull(user);
    }
}