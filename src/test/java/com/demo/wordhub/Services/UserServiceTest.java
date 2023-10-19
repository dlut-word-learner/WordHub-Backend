package com.demo.wordhub.Services;

import com.demo.wordhub.Mappers.UserMapper;
import com.demo.wordhub.Services.Impls.UserServiceImpl;
import com.demo.wordhub.Vos.UserRegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

// @SpringBootTest(classes = UserServiceImpl.class)
// @RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
// @AutoConfigureMockMvc
class UserServiceTest {
    @Mock
    UserMapper userMapper;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

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