package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.WordService;
import cn.dlut.conspirer.wordhub.Utils.SM2AlgorithmUtil;
import cn.dlut.conspirer.wordhub.Vos.LearnWordVo;
import cn.dlut.conspirer.wordhub.Vos.ReviewWordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/dicts/{dictId}/words")
public class WordController {
    WordService wordService;
    @Autowired
    WordController(WordService wordService){
        this.wordService = wordService;
    }

    /**
     * TODO
     * @param wordId
     * @return
     */
    @PostMapping("/{wordId}/learn")
    @SaCheckLogin
    public ResponseEntity<?> learnWord(@PathVariable("wordId") Long wordId, @RequestBody LearnWordVo learnWordVo){
        Long userId = StpUtil.getLoginIdAsLong();
        wordService.learnWord(userId, wordId, learnWordVo.isFamiliar());
        return ResponseEntity.ok().build();
    }

    /**
     * TODO
     * @param wordId
     * @return
     */
    @PostMapping ("/{wordId}/review")
    @SaCheckLogin
    public ResponseEntity<?> reviewWord(@PathVariable("wordId") Long wordId, @RequestBody ReviewWordVo reviewWordVo){
        Long userId = StpUtil.getLoginIdAsLong();
        StudyRec latest = wordService.getLatestStudyRec(userId, wordId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if(latest==null){
            return ResponseEntity.badRequest().body("请先学习再复习");
        }
        else if(latest.getTick()!=reviewWordVo.getTick()-1){
            return ResponseEntity.badRequest().body("tick不匹配");
        }
        else if(latest.getDueTime().toLocalDateTime().toLocalDate().isAfter(now.toLocalDateTime().toLocalDate())){
            return ResponseEntity.badRequest().body("还没到复习时间，请稍后再复习这个单词");
        }
        wordService.reviewWord(userId, wordId, reviewWordVo.getRating(), reviewWordVo.getTick());
        return ResponseEntity.ok().build();
    }

    @GetMapping ("/{wordId}/review")
    @SaCheckLogin
    public ResponseEntity<?> reviewWord(@PathVariable("wordId") Long wordId){
        Long userId = StpUtil.getLoginIdAsLong();
        ArrayList<Long> arr = new ArrayList<>();
        StudyRec latest = wordService.getLatestStudyRec(userId, wordId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if(latest==null){
            return ResponseEntity.badRequest().body("还没学过，无法推算");
        }
        else if(latest.getDueTime().toLocalDateTime().toLocalDate().isAfter(now.toLocalDateTime().toLocalDate())){
            return ResponseEntity.badRequest().body("还没到复习时间，无法推算");
        }
        arr.add(SM2AlgorithmUtil.calcGap(latest, SchedulingStates.Hard, now));
        arr.add(SM2AlgorithmUtil.calcGap(latest, SchedulingStates.Good, now));
        arr.add(SM2AlgorithmUtil.calcGap(latest, SchedulingStates.Easy, now));
        return ResponseEntity.ok(arr);
    }
}