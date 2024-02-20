// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 返回要复习的单词的Vo
 *
 * @author OuOu
 * @version 1.0
 */

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WordToReviewVo extends WordVo {
    Long tick;
}
