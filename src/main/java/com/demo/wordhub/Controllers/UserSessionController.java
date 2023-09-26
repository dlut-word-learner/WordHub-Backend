package com.demo.wordhub.Controllers;

import com.demo.wordhub.Vos.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
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
    public String login(@RequestBody UserLoginVo user){
        log.info(user.toString());
        if(Objects.equals(user.getUsername(), "abcd") && user.getPassword().equals("123456"))return "Successful";
        else return "Failed";
    }

}
