// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
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
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userService;

    /**
     * @TODO by damijiang123
     */
    @Test
    @Order(1)
    void register() throws Exception {
        Resource resource = new ClassPathResource("test_update_avatar.png");
        UserRegisterVo testUserRegisterVo = new UserRegisterVo("testUserName", "testPassword", "123@qwe.com", null);

        ObjectNode objectNode = objectMapper.valueToTree(testUserRegisterVo);

        mvc.perform(MockMvcRequestBuilders.multipart("/users")
                                          .file(new MockMultipartFile("avatar", resource.getContentAsByteArray()))
                                          .param("username", objectNode.get("username").toString())
                                          .param("email", objectNode.get("email").toString())
                                          .param("password", objectNode.get("password").toString())
        ).andExpect(status().isOk());
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