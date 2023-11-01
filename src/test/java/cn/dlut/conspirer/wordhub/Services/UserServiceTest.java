package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Mappers.UserMapper;
import cn.dlut.conspirer.wordhub.Services.Impls.UserServiceImpl;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    @MockBean
    String avatarPath = "./WordHub/avatars";
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

    @Test
    void updateUserProfile() throws IOException {
        // given
        User user = new User();
        user.setEmail("test1@te.st");
        user.setUsername("test_456");
        user.setPassword("Test456");
        user.setScore(0L);
        user.setScore(user.getScore() + 5L);
        userService.updateUserProfile(user);

        // then
        verify(userMapper).updateUserProfile(user);
    }
    @Test
    void updateUserPassword(){
        long testId = 1L;
        String testPassWord = "testPass888";
        userService.updateUserPassword(testId,testPassWord);
        verify(userMapper).updateUserPassword(testId,testPassWord);
    }

    /**   @Test
     *
     * TODO
     */
   /* void updateUserAvatar() throws IOException {
        long testId = 1L;

        byte[] testAvatar = getClass().getResourceAsStream("/test_update_avatar.png").readAllBytes();

        userService.updateUserAvatar(testId,testAvatar);
        verify(userService).updateUserAvatar(testId,testAvatar);

    }

    @Test
    void getAvatarById(){

    }
    *
    */
}

