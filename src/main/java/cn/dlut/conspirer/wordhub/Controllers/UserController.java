package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.User;
import cn.dlut.conspirer.wordhub.Services.UserService;
import cn.dlut.conspirer.wordhub.Vos.UserProfileUpdateVo;
import cn.dlut.conspirer.wordhub.Vos.UserRegisterVo;
import cn.dlut.conspirer.wordhub.Vos.UserVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    @GetMapping
    public ResponseEntity<List<UserVo>> getAll() {
        return ResponseEntity.ok(userService.getAll().stream().map(x -> {
            UserVo user = new UserVo();
            BeanUtils.copyProperties(x, user);
            return user;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @SaIgnore
    public ResponseEntity<UserVo> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        log.info(userVo.toString());
        return ResponseEntity.ok(userVo);
    }

    @GetMapping("/{id}/profile")
    @SaIgnore
    public ResponseEntity<UserVo> getUserProfileById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        log.info(userVo.toString());
        return ResponseEntity.ok(userVo);
    }

    @PutMapping("/{id}/profile")
    // 登录校验--只有登录之后才能进入该方法。
    @SaCheckLogin
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Validated @RequestBody UserProfileUpdateVo userVo) {
        // 只能修改自己的信息，不能修改别人的
        if (StpUtil.getLoginIdAsLong() != id) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("无权修改该用户的信息");
        }
        User user = userService.getUserById(id);
        if (user != null) {
            BeanUtils.copyProperties(userVo, user);
            userService.updateUserProfile(user);
            UserVo userVo1 = new UserVo();
            user = userService.getUserById(id);
            BeanUtils.copyProperties(user, userVo1);
            return ResponseEntity.ok(userVo1);
        } else return ResponseEntity.badRequest().body("用户不存在");
    }

    @GetMapping("/{id}/profile/avatar")
    @SaIgnore
    public ResponseEntity<?> getAvatar(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(userService.getAvatarById(id));
        } catch (IOException e) {
            log.error("GetAvatar failed: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/profile/avatar")
    @SaCheckLogin
    public ResponseEntity<?> updateAvatar(@PathVariable("id") Long id, @NotNull @RequestBody byte[] avatar){
        if (StpUtil.getLoginIdAsLong() != id) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("无权修改该用户的头像");
        }
        try {
            userService.updateUserAvatar(id, avatar);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            log.error("UpdateAvatar failed: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}/exp")
    @SaCheckLogin
    public ResponseEntity<?> addExp(@PathVariable("id") Long id, @RequestBody Long expToAdd) {
        if (StpUtil.getLoginIdAsLong() != id) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("无权修改该用户的经验");
        }
        Long exp = userService.addExp(id, expToAdd);
        if (exp != null) return ResponseEntity.ok(exp);
        else return ResponseEntity.badRequest().body("用户不存在");
    }
}
