package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Services.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * TODO
 * The type User controller test.
 */
//@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    @Order(1)
    void register() {
        // MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users").contentType("text");
    }

//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void getUserById() {
//    }
}