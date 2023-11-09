package cn.dlut.conspirer.wordhub.Vos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserProfileUpdateVo {
    @NotBlank(message = "{UserLoginVo.username_not_empty}")
    @NotBlank
    private String username;
    @NotBlank
    private String email;
}
