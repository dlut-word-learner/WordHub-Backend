package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;

import static cn.dlut.conspirer.wordhub.Utils.SM2AlgorithmUtil.calcGap;
import static cn.dlut.conspirer.wordhub.Utils.SM2AlgorithmUtil.clampEase;

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
        Double newEase = latest.getEase();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        long gap= calcGap(latest, rating, now);;
        if(latest.getGap()>=4){
            switch (rating){
                case Again -> {
                    newEase-=0.2;
                }
                case Hard -> {
                    newEase-=0.15;
                }
                case Good -> {

                }
                case Easy -> {
                    newEase+=0.15;
                }
            }
            newEase = clampEase(newEase);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.getTime());
        calendar.add(Calendar.DATE, Math.toIntExact(gap));
        Timestamp due = new Timestamp(calendar.getTimeInMillis());

        return wordMapper.insertStudyRec(userId, wordId, tick, gap, due, newEase)==1;
    }

    @Override
    public StudyRec getLatestStudyRec(Long userId, Long wordId){
        return wordMapper.getLatestStudyRec(userId, wordId);
    }
}
