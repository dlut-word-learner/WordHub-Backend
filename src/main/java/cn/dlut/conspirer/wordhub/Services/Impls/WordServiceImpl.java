package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.UserMapper;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Component
public class WordServiceImpl implements WordService {
    WordMapper wordMapper;

    @Autowired
    public WordServiceImpl(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public int addWordToDict(Long dictId, Word word) {
        return wordMapper.addWordToDict(dictId, word);
    }
}
