package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 网上说没这句可能导致无法成功注入，但实测是没问题的
//@RunWith(SpringRunner.class)
@MybatisTest
// 优先启用application-test.yml
@ActiveProfiles("test")
// MybatisTest默认使用H2数据库并固定了一些配置选项，所以需要手动配置这里来调用yml配置中的数据库url进行测试，以启用自定义的设置
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    User getTestUser() {
        User user = new User();
        user.setUsername("test_abc");
        user.setEmail("test@te.st");
        user.setPassword("Test123");
        return user;
    }

    @Test
    @Order(1)
    void addUser() {
        // given
        User user = getTestUser();

        // when
        int lines = userMapper.addUser(user);

        // then
        assertEquals(1, lines);
        assertNotNull(user.getId());
    }

    @Test
    @Order(2)
    void getAll() {
        // given
        User user = getTestUser();
        int lines = userMapper.addUser(user);

        // when
        List<User> users = userMapper.getAll();

        // then
        assertFalse(users.isEmpty());
    }

    @Test
    @Order(3)
    void deleteUser() {
        // given
        User user = getTestUser();
        userMapper.addUser(user);

        // when
        int lines = userMapper.deleteUser(user);

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

    @Test
    void testCRUD() {
        // given
        User user = getTestUser();

        // when add
        int lines = userMapper.addUser(user);

        // then
        assertEquals(1, lines);
        assertNotNull(user.getId());

        // when search
        User user_created = userMapper.getUserById(user.getId());

        // then
        assertNotNull(user_created);
        assertEquals(user.getUsername(), user_created.getUsername());
        assertNull(user_created.getAvatarPath());
        assertEquals(user_created.getScore(), 0);

        // when search all
        List<User> users = userMapper.getAll();

        // then
        Assertions.assertThat(users).contains(user_created);

        // when delete
        int lines_deleted = userMapper.deleteUser(user_created);

        // then
        assertEquals(lines_deleted, 1);
        users = userMapper.getAll();
        Assertions.assertThat(users).doesNotContain(user_created);
    }
}