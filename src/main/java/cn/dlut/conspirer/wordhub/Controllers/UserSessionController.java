package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Handle Login and Logout
 *
 * @author OuOu
 * @version 1.0
 */
@RestController
@RequestMapping("/sessions")
@Slf4j
@Validated
public class UserSessionController {
    private final UserService userService;

    @Autowired
    public UserSessionController(UserService userService) {
        this.userService = userService;
    }

    /**
     * user login api
     *
     * @param userLoginVo username and password to login
     * @return user info if succeeded, message if failed
     */
    @PostMapping
    public ResponseEntity<Object> login(@Validated @RequestBody UserLoginVo userLoginVo) {
        log.info(userLoginVo.toString());
        User user = userService.login(userLoginVo);
        if (user!=null){
            StpUtil.login(user.getId());
            return ResponseEntity.ok(user);
        }
        else return ResponseEntity.badRequest().body("账户或密码错误");
    }

    /**
     * Stateless JWT token does not need to logout on backend.
     */
    @SaCheckLogin
    @DeleteMapping
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("注销成功");
    }

}