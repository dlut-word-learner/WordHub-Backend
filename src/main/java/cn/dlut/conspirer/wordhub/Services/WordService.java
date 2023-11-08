/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.Word;

import java.util.List;

public interface WordService {
    // List<Word> getWordsByDict(Dict dict);

    // Word getWordByDictAndName(Dict dict, String name);

    int addWordToDict(Long dictId, Word word);

    void learnWord(Long userId, Long wordId, boolean familiar);

    void reviewWord(Long userId, Long wordId, SchedulingStates rating);
}
