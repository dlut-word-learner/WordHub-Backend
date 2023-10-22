package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import cn.hutool.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration Test for UserSession. And it's an example for tests with Sa-Token.
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class UserSessionTest {
    @Autowired
    WebApplicationContext context;

    @Autowired
    MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    void testLogin() throws Exception {
        UserLoginVo user = new UserLoginVo("test", "123456");
        when(userService.login(any())).thenReturn(new User(1L, "test", "123456", "1@a.cn", "1.png", 0L, (short) 0));
        String s = new ObjectMapper().writeValueAsString(user);
        mvc.perform(MockMvcRequestBuilders.post("/sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s))
                .andExpect(status().isOk());

        verify(userService).login(any());
    }

    /**
     * Expect Ok status as logging in at different devices at the same time is approved. And the token should be the same.
     */
    @Test
    void testRepeatLogin() throws Exception {
        StpUtil.login(1L);
        String originalToken = StpUtil.getTokenValue();
        UserLoginVo user = new UserLoginVo("test", "123456");

        when(userService.login(any())).thenReturn(new User(1L, "test", "123456", "1@a.cn", "1.png", 0L, (short) 0));
        String s = new ObjectMapper().writeValueAsString(user);

        mvc.perform(MockMvcRequestBuilders.post("/sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s))
                .andExpect(status().isOk())
                .andExpect(cookie().exists("satoken"));
    }

    /**
     * Expect an Unauthorized status without token
     */
    @Test
    void testLogoutWithoutLogin() throws Exception {
        // 没有登陆环境(token)
        mvc.perform(MockMvcRequestBuilders.delete("/sessions")).andExpect(status().isUnauthorized());
    }

    /**
     * Logout after login
     */
    @Test
    void testLogout() throws Exception {
        // 初始不应该是登录状态
        if (StpUtil.isLogin()) fail();
        // 先模拟一个登录
        StpUtil.login(12345);
        // 获取token
        String token = StpUtil.getTokenValue();
        assertNotNull(token);
        // 然后尝试注销，注意token要手动装载到MockMvcRequestBuilders的header里，name是satoken
        mvc.perform(MockMvcRequestBuilders.delete("/sessions").header("satoken", token)).andExpect(status().isOk());
    }
}