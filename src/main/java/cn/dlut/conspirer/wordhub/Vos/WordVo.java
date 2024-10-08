// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Word to return to the frontend
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WordVo {
    Long id;
    String name;
    //    Long dictId;
// 暂时不让extension与其它字段平级
//    @JsonUnwrapped
    WordExtensionVo extension;
}
