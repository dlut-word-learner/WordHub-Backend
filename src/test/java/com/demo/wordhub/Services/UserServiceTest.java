package com.demo.wordhub.Services;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Mappers.UserMapper;
import com.demo.wordhub.Services.Impls.UserServiceImpl;
import com.demo.wordhub.Vos.UserRegisterVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = UserServiceImpl.class)
//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class UserServiceTest {
    @MockBean
    UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void register() throws IOException {
        // given
        UserRegisterVo user = new UserRegisterVo();
        user.setUsername("test_123");
        user.setEmail("test@te.st");
        user.setPassword("Test123");

        // when
        userService.register(user);

        // then
        // 验证userMapper的addUser方法有没有被调用至少一次，不管参数
        verify(userMapper).addUser(any());
    }

    @Test
    void getAll() {
        // when
        userService.getAll();

        // then
        verify(userMapper).getAll();
    }

    @Test
    void getUserById() {
        // when
        userService.getUserById(1L);

        // then
        // 验证userMapper的getUserById方法被调用且参数为1L
        verify(userMapper).getUserById(eq(1L));
    }
}