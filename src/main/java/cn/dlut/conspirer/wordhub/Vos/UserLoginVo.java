package cn.dlut.conspirer.wordhub.Vos;

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
    @NotBlank(message = "{UserLoginVo.username_not_empty}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.username_len}")
    String username;
    @NotBlank(message = "{UserLoginVo.password_not_empty}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.password_len}")
    String password;
}
