// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

/**
 * 单词相关逻辑
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Entities.Word;

public interface WordService {
    // List<Word> getWordsByDict(Dict dict);

    // Word getWordByDictAndName(Dict dict, String name);

    int addWordToDict(Long dictId, Word word);

    boolean learnWord(Long userId, Long wordId, boolean familiar);


    boolean reviewWord(Long userId, Long wordId, SchedulingStates rating, Long tick);

    StudyRec getLatestStudyRec(Long userId, Long wordId);
}
