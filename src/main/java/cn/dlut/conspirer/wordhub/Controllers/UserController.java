package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles all requests related to the User entity.
 * It provides endpoints for user registration, retrieval, listing, searching, data update and account deletion.
 *
 * @author OuOu
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
@Slf4j
@Validated
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> register(@Validated UserRegisterVo user) {
        log.info("Registering " + user.toString());
        try {
            User new_user = userService.register(user);
            log.info("Register succeeded");
            return ResponseEntity.ok(new_user);
        } catch (Exception e) {
            log.error("Register failed: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
//        if(Objects.equals(user.getUsername(), "abcd") && user.getPassword().equals("123456"))return ResponseEntity.ok().build();
//        else return ResponseEntity.badRequest().body("账户或密码错误");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }
}
