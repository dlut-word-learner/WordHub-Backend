// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * View Object for User to return to the frontend
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Long id;
    private String username;
    private String email;
    private Long score;
    private Short role;
}
