// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * 处理用户登录的Vo
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {
    @NotBlank(message = "{UserLoginVo.username_not_empty}")
    @Length(min = 3, max = 20, message = "{UserLoginVo.username_len}")
    String username;
    @NotBlank(message = "{UserLoginVo.password_not_empty}")
    String password;
}
