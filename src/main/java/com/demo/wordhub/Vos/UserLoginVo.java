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
    @NotBlank(message = "{UserLoginVo.username}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.username_should_not_be_too_long_or_too_short}")
    String username;
    @NotBlank(message = "{UserLoginVo.password}")
    String password;
}
