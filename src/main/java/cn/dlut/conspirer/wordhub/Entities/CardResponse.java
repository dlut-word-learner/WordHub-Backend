// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目前进度用不到这个类
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    Long id;
    Long cardId;
    Long userId;
    CardResponseType type;
    String content;
}
