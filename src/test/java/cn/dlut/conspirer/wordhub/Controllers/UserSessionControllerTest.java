package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * TODO
 * Test UserSessionController.
 */
@WebMvcTest(UserSessionController.class)
class UserSessionControllerTest {
    @MockBean
    UserService userService;

    @Autowired
    UserSessionController userSessionController;
    @Test
    void test_login() {
        UserLoginVo user = new UserLoginVo("test","123456");
        userSessionController.login(user);
    }

    @Test
    void test_logout() {
        userSessionController.logout();
    }
}