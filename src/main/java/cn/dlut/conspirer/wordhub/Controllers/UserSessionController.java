package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final UserService userService;

    @Autowired
    public UserSessionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> login(@Validated UserLoginVo user) {
        log.info(user.toString());
        if (userService.login(user)) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().body("账户或密码错误");
//        if(Objects.equals(user.getUsername(), "abcd") && user.getPassword().equals("123456"))return ResponseEntity.ok().build();
//        else return ResponseEntity.badRequest().body("账户或密码错误");
    }

}