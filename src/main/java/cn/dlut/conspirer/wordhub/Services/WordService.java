/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Word;

import java.util.List;

public interface WordService {
    List<Word> getWordsByDict(Dict dict);

    Word getWordByDictAndName(Dict dict, String name);


}
