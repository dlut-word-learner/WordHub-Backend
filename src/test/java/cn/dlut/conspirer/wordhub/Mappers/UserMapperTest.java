package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ContextConfiguration(classes = WordHubApplication.class)
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
        user.setScore(0L);
        user.setRole((short) 0);
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
    @Order(4)
    void getUserByUsernameAndPassword() {
        User testUser = getTestUser();
        userMapper.addUser(testUser);
        User user = userMapper.getUserByUsernameAndPassword(testUser.getUsername(), testUser.getPassword());
        assertEquals(user, testUser);
    }

    @Test
    @Order(5)
    void getUserByIdAndPassword() {
        User testUser = getTestUser();
        userMapper.addUser(testUser);
        User user = userMapper.getUserByIdAndPassword(testUser.getId(), testUser.getPassword());
        assertEquals(user, testUser);
    }

    @Test
    @Order(6)
    void updateUserPassword() {
        User testUser = getTestUser();
        userMapper.addUser(testUser);
        String testPass = "test888";
        int lines = userMapper.updateUserPassword(testUser.getId(), testPass);
        testUser = userMapper.getUserById(testUser.getId());
        assertEquals(1, lines);
        assertEquals(testPass, testUser.getPassword());
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
    void updateUser() {
        // when
        User user = getTestUser();
        userMapper.addUser(user);
        user = userMapper.getUserById(user.getId());
        String newName = "test_cde";
        String newEmail = "test_cde@te.st";
        user.setUsername(newName);
        user.setEmail(newEmail);
        userMapper.updateUserProfile(user);
        user = userMapper.getUserById(user.getId());
        assertEquals(user.getEmail(), newEmail);
        assertEquals(user.getUsername(), newName);
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

    @Test
    @Sql("/data-testGetLearnTickNDaysBefore.sql")
    void testGetLearnTickNDaysBefore(){
        long userId = 1,n = 3;
        long Num = userMapper.getLearnTickNDaysBefore(userId,n);
        assertEquals(1L,Num);
    }


    @Test
    @Sql("/data-testGetLearnTickNDaysBefore.sql")
    void testGetReviewTickNDaysBefore(){
        long userId = 1,n = 3;
        long Num = userMapper.getReviewTickNDaysBefore(userId,n);
        assertEquals(1L,Num);
    }

    @Test
    @Sql("/data-testGetQwertyTickNDaysBefore.sql")
    void testGetQwertyTickNDaysBefore(){
        long userId = 1,n = 3;
        long Num = userMapper.getQwertyTickNDaysBefore(userId,n);
        assertEquals(10L,Num);
    }



}