/**
 * 词库相关逻辑
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Dtos.WordToReviewDTO;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Vos.DictProgressVo;

import java.util.List;

public interface DictService {
    List<Dict> getAllDictionaries();

    List<Dict> getDictionariesByLanguage(Languages lang);

    Dict getDictionaryById(Long id);

    List<Word> getWordsToLearn(Long dictId, Long userId, Long num);

    Long getWordsNumToReview(Long dictId, Long userId);

    List<WordToReviewDTO> getWordsToReview(Long dictId, Long userId, Long num);

    List<Word> getWordsToQwerty(Long dictId, Long num);

    boolean addDict(Dict dict);

    boolean addQwertyRec(Long userId, Long dictId, Long num);

    DictProgressVo getProgress(Long userId, Long dictId);

    List<Dict> getRecentlyUsedDicts(Long userId, Long n);
}
