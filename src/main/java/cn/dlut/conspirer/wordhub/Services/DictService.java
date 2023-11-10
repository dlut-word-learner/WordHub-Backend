/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Dtos.WordToReviewDTO;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;

import java.util.List;

public interface DictService {
    List<Dict> getAllDictionaries();

    List<Dict> getDictionariesByLanguage(Languages lang);

    Dict getDictionaryById(Long id);

    List<Word> getWordsToLearn(Long dictId, Long userId, Long num);

    List<WordToReviewDTO> getWordsToReview(Long dictId, Long userId, Long num);

    List<Word> getWordsToQwerty(Long dictId, Long num);

    int addDict(Dict dict);
}
