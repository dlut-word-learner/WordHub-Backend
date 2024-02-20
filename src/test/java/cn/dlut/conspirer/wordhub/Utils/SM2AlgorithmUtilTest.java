// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Utils;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
public class SM2AlgorithmUtilTest {

    @Test
    @Order(1)
    void testClampEase(){
        double MaxEase = SM2AlgorithmUtil.MAX_EASE+1,
                MinEase = SM2AlgorithmUtil.MIN_EASE-1,
                testEASE = (SM2AlgorithmUtil.MAX_EASE+SM2AlgorithmUtil.MIN_EASE)*0.5;
        assertEquals(SM2AlgorithmUtil.MAX_EASE,SM2AlgorithmUtil.clampEase(MaxEase));
        assertEquals(SM2AlgorithmUtil.MIN_EASE,SM2AlgorithmUtil.clampEase(MinEase));
        assertEquals(testEASE,SM2AlgorithmUtil.clampEase(testEASE));
    }

    StudyRec getStudyRec_1(){
        long id =100L;long wordId = 1001L;long UserId = 10001L;long gap = 1L;
        double ease = (SM2AlgorithmUtil.MAX_EASE+SM2AlgorithmUtil.MIN_EASE)*0.5;
        String str = "2023-10-1 15:40:00";
        Timestamp dueTime = Timestamp.valueOf(str);
        long tick = 1;
        return(new StudyRec(id,wordId,UserId,gap,ease,dueTime,tick));
    }
    /**
     *   getStudyRec_1 ：ease = 1.9，2023-10-1 15:40:00
     * 第一次测试:   gap = 1
     *
     */
    @Test
    @Order(2)
    void testCalcGap_1(){
        StudyRec studyRec_1 = getStudyRec_1();
        SchedulingStates scheduLingStates_easy = SchedulingStates.Easy;
        String strTime = "2023-10-2 15:40:00";
        Timestamp now = Timestamp.valueOf(strTime);
        long gap = SM2AlgorithmUtil.calcGap(studyRec_1,scheduLingStates_easy,now);
        assertEquals(gap,2L);
    }


    StudyRec getStudyRec_2(){
        long id =100L; long wordId = 1001L;long UserId = 10001L;long gap = 5L;
        double ease = (SM2AlgorithmUtil.MAX_EASE+SM2AlgorithmUtil.MIN_EASE)*0.5;
        String str = "2023-10-1 15:40:00";
        Timestamp dueTime = Timestamp.valueOf(str);
        long tick = 1;
        return(new StudyRec(id,wordId,UserId,gap,ease,dueTime,tick));
    }
    /**
     *getStudyRec_2 ：ease = 1.9，2023-10-1 15:40:00
     *第二次测试  1.9*2(5+gap/2)  gap=5-1
     * 应为26
     */
    @Test
    
    @Order(3)
    void testCalcGap_2(){
        StudyRec studyRec_2 = getStudyRec_2();
        SchedulingStates scheduLingStates_easy = SchedulingStates.Easy;
        String strTime = "2023-10-5 15:40:00";
        Timestamp now = Timestamp.valueOf(strTime);
        long gap = SM2AlgorithmUtil.calcGap(studyRec_2,scheduLingStates_easy,now);
        assertEquals(1.9,studyRec_2.getEase());
         assertEquals(26L,gap);
    }
    StudyRec getStudyRec_3(){
        long id =100L; long wordId = 1001L;long UserId = 10001L;long gap = 4L;
        double ease = (SM2AlgorithmUtil.MAX_EASE+SM2AlgorithmUtil.MIN_EASE)*0.5;
        String str = "2023-10-1 15:40:00";
        Timestamp dueTime = Timestamp.valueOf(str);
        long tick = 1;
        return(new StudyRec(id,wordId,UserId,gap,ease,dueTime,tick));
    }
    //第三次测试  1.2(4+(10-1)/4)=7.5
    @Test
    @Order(3)
    void testCalcGap_3(){
        StudyRec studyRec_3 = getStudyRec_3();
        SchedulingStates scheduLingStates_hard = SchedulingStates.Hard;
        String strTime = "2023-10-10 15:40:00";
        Timestamp now = Timestamp.valueOf(strTime);
        long gap = SM2AlgorithmUtil.calcGap(studyRec_3,scheduLingStates_hard,now);
        assertEquals(7L,gap);
    }

}
