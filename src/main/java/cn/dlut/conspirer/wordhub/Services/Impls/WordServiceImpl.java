package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
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
     *
     * @param userId
     * @param wordId
     * @param familiar
     * @return
     */
    @Override
    public boolean learnWord(Long userId, Long wordId, boolean familiar) {
        return false;
    }

    /**
     * TODO
     * @param userId
     * @param wordId
     * @param rating
     * @param tick
     */
    @Override
    public boolean reviewWord(Long userId, Long wordId, SchedulingStates rating, Long tick){
        StudyRec latest = wordMapper.getLatestStudyRec(userId, wordId);
        if(latest == null) return false;
        return false;
    }
}
