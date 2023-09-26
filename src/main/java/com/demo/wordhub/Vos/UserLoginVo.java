package com.demo.wordhub.Vos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Getter
@ToString
public class UserLoginVo {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "{UserLoginVo.username}")
    String username;
    @NotBlank(message = "{UserLoginVo.password}")
    String password;
}
