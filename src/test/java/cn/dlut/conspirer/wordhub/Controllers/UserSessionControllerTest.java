package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for UserSessionController. And it's an example for unit tests for Controllers with Sa-Token.
 * Authorization We should not be tested in the unit tests so stpUtil is mocked.
 */
@WebMvcTest(UserSessionController.class)
@ExtendWith({RestDocumentationExtension.class, MockitoExtension.class})
class UserSessionControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Mock
    StpLogicJwtForStateless stpLogic;

    @BeforeEach
    void init() {
        StpUtil.setStpLogic(stpLogic);
//        Mockito.when(stpLogic.isLogin()).thenReturn(true);
    }

    @Test
    void login() throws Exception {
        UserLoginVo userLoginVo = new UserLoginVo("test", "123456");
        when(userService.login(any())).thenReturn(new User(1L, "test", "123456", "1@a.cn", "1.png", 0L, (short) 0));
        String s = objectMapper.writeValueAsString(userLoginVo);
        mvc.perform(MockMvcRequestBuilders.post("/sessions").contentType(MediaType.APPLICATION_JSON).content(s)).andExpect(status().isOk());
        verify(userService).login(userLoginVo);
    }
}