package cn.dlut.conspirer.wordhub.Utils;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
public class SM2AlgorithmUtil {
    private static final Logger log = LoggerFactory.getLogger(SM2AlgorithmUtil.class);

    public static final double MIN_EASE = 1.3;
    public static final double MAX_EASE = 2.5;
    public static final double EASE_FACTOR_INITIAL = 2.3;
    public static final double EASY_REWARD = 2.0;

    /**
     * 困难分类值
     */
    public static final HashMap<SchedulingStates, Double> DIFFICULTY_CATE = new HashMap<>(){{
        put(SchedulingStates.Good, 1.0);
        put(SchedulingStates.Easy, 2.0);
        put(SchedulingStates.Hard, 4.0);
    }};

    /**
     * ease变化值
     */
    public static final HashMap<SchedulingStates, Double> EASE_CHANGE = new HashMap<>(){{
        put(SchedulingStates.Good, 0.);
        put(SchedulingStates.Easy, 0.15);
        put(SchedulingStates.Hard, -0.15);
    }};

    /**
     * 指数增长因子
     */
    public static Double getExpFactor(SchedulingStates state, Double ease){
        switch (state){
            case Hard -> {
                return 1.2;
            }
            case Good -> {
                return ease;
            }
            case Easy -> {
                return ease * EASY_REWARD;
            }
            default -> {
                log.error("不应出现Again");
                return 1.;
            }
        }
    }


    public static double clampEase(Double ease){
        return ease > MAX_EASE ? MAX_EASE : (ease < MIN_EASE ? MIN_EASE :ease);
    }

    /**
     * 计算下次的间隔 <br/>
     * 公式：系数 * （lastGap + delayDays / difficulty） <br/>
     * 系数：good: ease, hard: 1.2, easy: ease * reward
     *
     * @param lastRec
     * @param state
     * @return
     */
    public static Long calcGap(StudyRec lastRec, SchedulingStates state, Timestamp now){
        if(lastRec.getGap()<4)return lastRec.getGap()*2;
        Double coefficient = getExpFactor(state, lastRec.getEase());

        return (long) (coefficient * (lastRec.getGap() + ChronoUnit.DAYS.between(lastRec.getDueTime().toLocalDateTime().toLocalDate(), now.toLocalDateTime().toLocalDate())/DIFFICULTY_CATE.get(state)));
    }
}
