package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.DictMapper;
import cn.dlut.conspirer.wordhub.Services.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
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
    public int addDict(Dict dict) {
        return dictMapper.addDict(dict);
    }
}
