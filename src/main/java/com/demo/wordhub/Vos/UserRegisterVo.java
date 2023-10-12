package com.demo.wordhub.Vos;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Getter
public class UserRegisterVo {

    private Long id;
    @NotBlank(message = "{UserLoginVo.username_not_empty}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.username_len}")
    private String username;
    @NotBlank(message = "{UserLoginVo.password_not_empty}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.password_len}")
    private String password;
    @Email
    private String email;

    private MultipartFile avatar;
}
