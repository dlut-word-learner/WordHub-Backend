package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.verify;

/**
 * TODO
 * The type User controller test.
 */
//@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = WordHubApplication.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    /**
     *
     * @TODO
     * by damijiang123
     */
    @Test
    @Order(1)
    void register() throws Exception {
        Resource resource = new ClassPathResource("test_update_avatar.png");
        MockMultipartFile testMultipartFile=new MockMultipartFile(
                "testFile","test_avatar.png","image/png", resource.getInputStream()
        );
        UserRegisterVo testUserRegisterVo = new UserRegisterVo("testUserName","testPassword","12345678@testmail.com",testMultipartFile);
        mvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.MULTIPART_FORM_DATA).content(objectMapper.writeValueAsString(testUserRegisterVo)));

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