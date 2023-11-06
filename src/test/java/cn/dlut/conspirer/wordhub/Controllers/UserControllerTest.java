package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.Part;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 * The type User controller test.
 */
//@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = WordHubApplication.class)
@ExtendWith({RestDocumentationExtension.class, MockitoExtension.class})
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * @TODO by damijiang123
     * No serializer found for class java.io.ByteArrayInputStream and no properties discovered to create BeanSerializer
     * I have no idea  to test the "register" too.
     */
    @Test
    @Order(1)
    void register() throws Exception {
        Resource resource = new ClassPathResource("test_update_avatar.png");
        MockMultipartFile testMultipartFile = new MockMultipartFile(
                "avatar", "test_avatar.png", "image/png", resource.getInputStream()
        );
        UserRegisterVo testUserRegisterVo = new UserRegisterVo("testUserName", "testPassword", "12345678@testmail.com", null);

        ObjectNode objectNode = objectMapper.valueToTree(testUserRegisterVo);

        mvc.perform(MockMvcRequestBuilders.post("/users").contentType("Multipart/Form-data").content(objectNode.without("avatar").toString())).andExpect(status().isOk());
        verify(userService).register(any());
        // MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users").contentType("text");
    }

    @Test
    @Order(2)
    void getAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users"));
        verify(userService).getAll();
    }

//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void getUserById() {
//    }
}