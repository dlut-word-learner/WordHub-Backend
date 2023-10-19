/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Services;

import com.demo.wordhub.Entities.Dict;
import com.demo.wordhub.Entities.Word;

import java.util.List;

public interface WordService {
    List<Word> getWordsByDict(Dict dict);

    Word getWordByDictAndName(Dict dict, String name);


}
