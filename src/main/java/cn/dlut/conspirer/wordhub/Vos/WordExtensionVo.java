// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Vos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Extension field of WordVo
 *
 * @author OuOu
 * @version 1.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WordExtensionVo {
    @JsonAlias("trans")
    List<String> meanings;
    /**
     * 英语：美式发音
     */
    String usphone;
    /**
     * 英语：英式发音
     */
    String ukphone;
    /**
     * 日语：汉字（假名）表示
     */
    String notation;
}
