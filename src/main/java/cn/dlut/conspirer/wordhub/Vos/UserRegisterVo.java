package cn.dlut.conspirer.wordhub.Vos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterVo {
    @NotBlank(message = "{UserLoginVo.username_not_empty}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.username_len}")
    private String username;
    @NotBlank(message = "{UserLoginVo.password_not_empty}")
    // 后端接收的密码已经经过哈希，不需要判断长短
//    @Length(min = 3, max = 20, message = "{UserLoginVo.password_len}")
    private String password;
    private String email;

    private MultipartFile avatar;
}
