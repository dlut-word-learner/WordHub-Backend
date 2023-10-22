package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for UserSessionController. And it's an example for unit tests for Controllers with Sa-Token.
 * Authorization We should not be tested in the unit tests so stpUtil is mocked.
 */
@WebMvcTest(UserSessionController.class)
@ExtendWith(MockitoExtension.class)
class UserSessionControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    MockedStatic<StpUtil> stpUtil;

    @BeforeEach
    void init(){
        stpUtil = mockStatic(StpUtil.class);
        assertNull(StpUtil.getTokenValue());
        assertNull(StpUtil.getLoginId());
        // Notice that Login status will be false as boolean do not have Null value.
        assertFalse(StpUtil.isLogin());
    }

    @AfterEach
    void closeStatic(){
        stpUtil.close();
    }

    @Test
    void login() throws Exception {
        UserLoginVo userLoginVo = new UserLoginVo("test","123456");
        when(userService.login(any())).thenReturn(new User(1L, "test", "123456", "1@a.cn", "1.png", 0L, (short) 0));
        String s = objectMapper.writeValueAsString(userLoginVo);
        mvc.perform(MockMvcRequestBuilders.post("/sessions").contentType(MediaType.APPLICATION_JSON).content(s)).andExpect(status().isOk());
        verify(userService).login(userLoginVo);
    }
}