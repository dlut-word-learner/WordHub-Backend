package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Services.WordService;
import cn.dlut.conspirer.wordhub.Utils.SM2AlgorithmUtil;
import cn.dlut.conspirer.wordhub.Vos.LearnWordVo;
import cn.dlut.conspirer.wordhub.Vos.ReviewWordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 主要处理学习复习记录的上传入库，因为它们是以单词而不是词库为单位的
 * 还加了一个预先GET获取选Hard Good Easy时下次复习时间的API
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
    WordController(WordService wordService) {
        this.wordService = wordService;
    }

    /**
     * 处理学习一个单词的逻辑
     *
     * @param wordId
     * @return
     */
    @PostMapping("/{wordId}/learn")
    @SaCheckLogin
    public ResponseEntity<?> learnWord(@PathVariable("wordId") Long wordId, @RequestBody LearnWordVo learnWordVo) {
        Long userId = StpUtil.getLoginIdAsLong();
        wordService.learnWord(userId, wordId, learnWordVo.isFamiliar());
        return ResponseEntity.ok().build();
    }

    /**
     * 处理复习一个单词的逻辑
     *
     * @param wordId
     * @return
     */
    @PostMapping("/{wordId}/review")
    @SaCheckLogin
    public ResponseEntity<?> reviewWord(@PathVariable("wordId") Long wordId, @RequestBody ReviewWordVo reviewWordVo) {
        Long userId = StpUtil.getLoginIdAsLong();
        StudyRec latest = wordService.getLatestStudyRec(userId, wordId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (latest == null) {
            return ResponseEntity.badRequest().body("请先学习再复习");
        } else if (latest.getTick() != reviewWordVo.getTick() - 1) {
            return ResponseEntity.badRequest().body("tick不匹配");
        } else if (latest.getDueTime().toLocalDateTime().toLocalDate().isAfter(now.toLocalDateTime().toLocalDate())) {
            return ResponseEntity.badRequest().body("还没到复习时间，请稍后再复习这个单词");
        }
        wordService.reviewWord(userId, wordId, reviewWordVo.getRating(), reviewWordVo.getTick());
        return ResponseEntity.ok().build();
    }

    /**
     * 获取如果点击Hard, Good, Easy分别会规划到多少天后复习
     * @param wordId
     * @return
     */
    @GetMapping("/{wordId}/review")
    @SaCheckLogin
    public ResponseEntity<?> reviewWord(@PathVariable("wordId") Long wordId) {
        Long userId = StpUtil.getLoginIdAsLong();
        ArrayList<Long> arr = new ArrayList<>();
        StudyRec latest = wordService.getLatestStudyRec(userId, wordId);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (latest == null) {
            return ResponseEntity.badRequest().body("还没学过，无法推算");
        } else if (latest.getDueTime().toLocalDateTime().toLocalDate().isAfter(now.toLocalDateTime().toLocalDate())) {
            return ResponseEntity.badRequest().body("还没到复习时间，无法推算");
        }
        arr.add(SM2AlgorithmUtil.calcGap(latest, SchedulingStates.Hard, now));
        arr.add(SM2AlgorithmUtil.calcGap(latest, SchedulingStates.Good, now));
        arr.add(SM2AlgorithmUtil.calcGap(latest, SchedulingStates.Easy, now));
        return ResponseEntity.ok(arr);
    }
}