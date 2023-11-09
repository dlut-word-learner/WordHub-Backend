package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.WordService;
import cn.dlut.conspirer.wordhub.Utils.SM2AlgorithmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;

import static cn.dlut.conspirer.wordhub.Utils.SM2AlgorithmUtil.*;

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
     * 学习新单词（或者不是新的但忘记了重学）
     *
     * @param userId
     * @param wordId
     * @param familiar 是否熟悉，熟悉的话可以四天后再复习
     * @return
     */
    @Override
    public boolean learnWord(Long userId, Long wordId, boolean familiar) {
        StudyRec latest = wordMapper.getLatestStudyRec(userId, wordId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.getTime());
        calendar.add(Calendar.DATE, Math.toIntExact(1L));
        Long gap = latest == null ? (familiar ? 4L : 1L) : latest.getTick() + 1;
        return wordMapper.insertStudyRec(userId, wordId, gap, 1L, new Timestamp(calendar.getTimeInMillis()), SM2AlgorithmUtil.EASE_FACTOR_INITIAL) == 1;
    }

    /**
     * 复习单词<br/>
     * <p>
     * 调用 SM-2 算法计算下次应该隔多久复习，并更新单词的ease值
     *
     * @param userId
     * @param wordId
     * @param rating 记忆评级
     * @param tick   本次是第几次学习
     */
    @Override
    public boolean reviewWord(Long userId, Long wordId, SchedulingStates rating, Long tick) {
        StudyRec latest = wordMapper.getLatestStudyRec(userId, wordId);
        if (latest == null) return false;
        Double newEase = latest.getEase();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        long gap = calcGap(latest, rating, now);

        if (latest.getGap() >= 4) {
            newEase += EASE_CHANGE.get(rating);
            newEase = clampEase(newEase);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now.getTime());
        calendar.add(Calendar.DATE, Math.toIntExact(gap));
        Timestamp due = new Timestamp(calendar.getTimeInMillis());

        return wordMapper.insertStudyRec(userId, wordId, tick, gap, due, newEase) == 1;
    }

    @Override
    public StudyRec getLatestStudyRec(Long userId, Long wordId) {
        return wordMapper.getLatestStudyRec(userId, wordId);
    }
}
