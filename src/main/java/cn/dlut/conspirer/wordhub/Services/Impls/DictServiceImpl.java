package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Dtos.WordToReviewDTO;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.DictMapper;
import cn.dlut.conspirer.wordhub.Services.DictService;
import cn.dlut.conspirer.wordhub.Vos.DictProgressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Dict Service的实现
 *
 * @author OuOu
 * @version 1.0
 */
@Service
public class DictServiceImpl implements DictService {
    DictMapper dictMapper;

    @Autowired
    public DictServiceImpl(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    @Override
    public List<Dict> getAllDictionaries() {
        return dictMapper.getDicts();
    }

    @Override
    public List<Dict> getDictionariesByLanguage(Languages lang) {
        return dictMapper.getDictsByLanguage(lang);
    }

    @Override
    public Dict getDictionaryById(Long id) {
        return dictMapper.getDictById(id);
    }

    @Override
    public List<Word> getWordsToLearn(Long dictId, Long userId, Long num) {
        return dictMapper.getWordsToLearn(dictId, userId, num);
    }

    @Override
    public List<WordToReviewDTO> getWordsToReview(Long dictId, Long userId, Long num) {
        return dictMapper.getWordsToReview(dictId, userId, num);
    }

    @Override
    public List<Word> getWordsToQwerty(Long dictId, Long num) {
        return dictMapper.getWordsToQwerty(dictId, num);
    }

    @Override
    public boolean addDict(Dict dict) {
        return dictMapper.addDict(dict) == 1L;
    }

    @Override
    public boolean addQwertyRec(Long userId, Long dictId, Long num){
        return dictMapper.insertQwertyRec(dictId, userId, num) == 1L;
    }

    /**
     * 获取一个用户对一个词典的学习进度
     * @param userId
     * @param dictId
     * @return
     */
    @Override
    public DictProgressVo getProgress(Long userId, Long dictId){
        return DictProgressVo.builder().sum(dictMapper.getWordNum(dictId)).studied(dictMapper.getNumUnmastered(dictId, userId)).mastered(dictMapper.getNumMastered(dictId, userId)).build();
    }
}
