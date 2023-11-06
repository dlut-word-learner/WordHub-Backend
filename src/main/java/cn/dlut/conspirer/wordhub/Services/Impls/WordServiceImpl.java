package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /**
     * TODO
     * @param userId
     * @param wordId
     * @param familiar
     */
    @Override
    public void learnWord(Long userId, Long wordId, boolean familiar) {

    }

    /**
     * TODO
     * @param userId
     * @param wordId
     * @param rating
     */
    @Override
    public void reviewWord(Long userId, Long wordId, SchedulingStates rating){

    }
}
