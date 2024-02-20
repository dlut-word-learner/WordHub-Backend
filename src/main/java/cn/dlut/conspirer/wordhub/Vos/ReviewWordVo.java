// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 复习单词的接口 <br/>
 * 包含记忆评级与第几次复习信息
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewWordVo {
    SchedulingStates rating;
    Long tick;
}
