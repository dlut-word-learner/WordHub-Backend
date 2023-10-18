package com.demo.wordhub.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        // 不加载servlet服务，可以加速
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        // 指定上下文，可以减少要装配的bean，提高速度
        classes = UserSessionController.class
)
class UserSessionControllerTest {

//    @Test
//    void test_login() {
//
//    }
}