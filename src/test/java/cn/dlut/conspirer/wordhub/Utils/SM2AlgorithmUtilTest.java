package cn.dlut.conspirer.wordhub.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
public class SM2AlgorithmUtilTest {

    StudyRec getStudyRec_1(){
        long id =100L;
        long wordId = 1001L;
        long UserId = 10001L;
        long gap = 1L;
        //ease = 1.9
        double ease = SM2AlgorithmUtil.MAX_EASE+SM2AlgorithmUtil.MIN_EASE;
        String str = "2023-10-1 15:40:00";
        Timestamp timestamp = Timestamp.valueOf(str);
        long tick = 1;
        return(new StudyRec(id,wordId,UserId,gap,ease,timestamp,tick));
    }

    @Test
    void testClampEase(){
        double MaxEase = SM2AlgorithmUtil.MAX_EASE+1,
                MinEase = SM2AlgorithmUtil.MIN_EASE-1,
                testEASE = (SM2AlgorithmUtil.MAX_EASE+SM2AlgorithmUtil.MIN_EASE)*0.5;
        assertEquals(SM2AlgorithmUtil.MAX_EASE,SM2AlgorithmUtil.clampEase(MaxEase));
        assertEquals(SM2AlgorithmUtil.MIN_EASE,SM2AlgorithmUtil.clampEase(MinEase));
        assertEquals(testEASE,SM2AlgorithmUtil.clampEase(testEASE));
    }

    @Test
    void testcalcGap(){

        //1.9*2(2-1/2)
        StudyRec studyRec_1 = getStudyRec_1();
        SchedulingStates scheduLingStates_easy = SchedulingStates.Easy;
        String strTime = "2023-10-2 15:40:00";
        Timestamp now = Timestamp.valueOf(strTime);
        long gap_1 = SM2AlgorithmUtil.calcGap(studyRec_1,scheduLingStates_easy,now);
     //   assertThat(gap_1,greaterThanOrEqualTo(7L));
    }
}
