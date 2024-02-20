// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.WordHubApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@ContextConfiguration(classes = WordHubApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Slf4j
class WordMapperTest {
    @Autowired
    WordMapper wordMapper;

    @Test
    void testInsertStudyRec() {
        long wordId = 1000001L, userId = 1000001L, RecTick = 1,
                RecGap = 1;
        String strTime = "2023-10-1 15:40:00";
        Timestamp dueTime = Timestamp.valueOf(strTime);
        double testEase = 2;
        int lines = wordMapper.insertStudyRec(wordId, userId, RecTick, RecGap, dueTime, testEase);
        assertEquals(1, lines);
    }

    StudyRec getTestStudyRec() {
        long id = 1L, wordID = 101L, userId = 1L,gap = 1L,tick = 1;
        double ease = 2.0;
        String strTime = "2023-11-09 10:01:04";
        Timestamp dueTime = Timestamp.valueOf(strTime);
        return(new StudyRec(id,wordID,userId,gap,ease,dueTime,tick));
    }

    @Test
    @Sql("/data-testGetLatestStudyRec.sql")
    void testGetLatestStudyRec() {
        long userId = 1L;
        long WordId = 101L;
        StudyRec Rec = wordMapper.getLatestStudyRec(userId, WordId);
        assertEquals(1, Rec.getId());
        StudyRec testStudyRec = getTestStudyRec();
        assertEquals(testStudyRec,Rec);
    }

    ;


}