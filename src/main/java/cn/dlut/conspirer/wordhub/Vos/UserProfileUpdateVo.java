// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 处理用户信息更改的Vo
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
