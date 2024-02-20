// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 目前进度暂时用不到这个类
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private Long wordId;
    private Long userId;
    private String content;
    private boolean isPublic;
}
