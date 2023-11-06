package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Mappers.WordMapper;
import cn.dlut.conspirer.wordhub.Services.WordService;
import cn.dlut.conspirer.wordhub.Vos.LearnWordVo;
import cn.dlut.conspirer.wordhub.Vos.ReviewWordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.internalServerError().build();
    }

    /**
     * TODO
     * @param wordId
     * @return
     */
    @PutMapping("/{wordId}/review")
    @SaCheckLogin
    public ResponseEntity<?> reviewWord(@PathVariable("wordId") Long wordId, @RequestBody ReviewWordVo reviewWordVo){
        Long userId = StpUtil.getLoginIdAsLong();
        wordService.reviewWord(userId, wordId, reviewWordVo.getRating());
        return ResponseEntity.internalServerError().build();
    }
}
