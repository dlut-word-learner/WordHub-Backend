package com.demo.wordhub.Controllers;

import com.demo.wordhub.Entities.User;
import com.demo.wordhub.Services.UserService;
import com.demo.wordhub.Vos.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
@Slf4j
@Validated
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> register(@Validated @RequestBody UserLoginVo user){
        log.info("Register"+user.toString());
        userService.register(user);
        return ResponseEntity.ok().build();
//        if(Objects.equals(user.getUsername(), "abcd") && user.getPassword().equals("123456"))return ResponseEntity.ok().build();
//        else return ResponseEntity.badRequest().body("账户或密码错误");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
