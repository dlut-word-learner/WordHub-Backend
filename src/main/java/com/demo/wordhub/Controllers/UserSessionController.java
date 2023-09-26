package com.demo.wordhub.Controllers;

import cn.dev33.satoken.util.SaResult;
import com.demo.wordhub.Vos.ResponseVo;
import com.demo.wordhub.Vos.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@RestController
@RequestMapping("/session")
@Slf4j
@Validated
public class UserSessionController {
    @PostMapping
    public ResponseVo login(@Validated @RequestBody UserLoginVo user){
        log.info(user.toString());
        if(Objects.equals(user.getUsername(), "abcd") && user.getPassword().equals("123456"))return new ResponseVo(HttpStatus.OK);
        else return new ResponseVo(HttpStatus.BAD_REQUEST.value(),"账户或密码错误");
    }

}
