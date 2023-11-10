package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Dtos.WordToReviewDTO;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Task;
import cn.dlut.conspirer.wordhub.Services.DictService;
import cn.dlut.conspirer.wordhub.Vos.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles requests related to the Dict entity.
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/dicts")
public class DictController {
    DictService dictService;
    ObjectMapper objectMapper;

    @Autowired
    DictController(DictService dictService, ObjectMapper objectMapper) {

        this.dictService = dictService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<DictVo>> getDictionaries(@RequestParam @Nullable Languages lang) {
        log.info("language: " + lang);
        return ResponseEntity.ok((lang != null ? dictService.getDictionariesByLanguage(lang) : dictService.getAllDictionaries()).stream().map(x -> {
            DictVo dictVo = new DictVo();
            BeanUtils.copyProperties(x, dictVo);
            return dictVo;
        }).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DictVo> getDictionary(@PathVariable("id") Long dictId) {
        Dict dict = dictService.getDictionaryById(dictId);
        DictVo dictVo = new DictVo();
        BeanUtils.copyProperties(dict, dictVo);
        return ResponseEntity.ok(dictVo);
    }

    /**
     * @param dictId
     * @param num
     * @return num words to learn
     */
    @GetMapping("/{id}/learn")
    @SaCheckLogin
    public ResponseEntity<?> getWordsToLearn(@PathVariable("id") Long dictId, @RequestParam @Nullable Long num) {
        Long userId = StpUtil.getLoginIdAsLong();
        if (num == null) num = 20L;
        // Languages lang = dictService.getLanguageByDictId(dictId);
        List<WordVo> wordList = dictService.getWordsToLearn(dictId, userId, num).stream().map(x -> {
            try {
                return WordVo.builder()
                             .id(x.getId())
                             .name(x.getName())
                             .extension(objectMapper.treeToValue(x.getExtension(), WordExtensionVo.class))
                             .build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return ResponseEntity.ok(wordList);
    }

    @GetMapping("/{id}/review")
    @SaCheckLogin
    public ResponseEntity<?> getWordsToReview(@PathVariable("id") Long dictId, @RequestParam @Nullable Long num) {
        Long userId = StpUtil.getLoginIdAsLong();
        if (num == null) num = 20L;
        // Languages lang = dictService.getLanguageByDictId(dictId);
        List<WordToReviewDTO> wordList = dictService.getWordsToReview(dictId, userId, num);
        return ResponseEntity.ok(wordList);
    }

    /**
     * Do not need to log in
     * @param dictId
     * @param num
     * @return num words to learn
     */
    @GetMapping("/{id}/qwerty")
    public ResponseEntity<?> getWordsToQwerty(@PathVariable("id") Long dictId, @RequestParam @Nullable Long num) {
        if (num == null) num = 20L;
        // Languages lang = dictService.getLanguageByDictId(dictId);
        List<WordVo> wordList = dictService.getWordsToQwerty(dictId, num).stream().map(x -> {
            try {
                return WordVo.builder()
                             .id(x.getId())
                             .name(x.getName())
                             .extension(objectMapper.treeToValue(x.getExtension(), WordExtensionVo.class))
                             .build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return ResponseEntity.ok(wordList);
    }

    /**
     * TODO
     *
     * 获取用户对此词典过去n天的学习/复习/Qwerty记录，返回 长度为n的整型数组
     * @param dictId
     * @param task
     * @return
     */
    @GetMapping("/{id}/study-rec/{task}")
    @SaCheckLogin
    public ResponseEntity<?> getStudyRec(@PathVariable("id") Long dictId, @PathVariable("task")Task task) {
        Long userId = StpUtil.getLoginIdAsLong();
        switch(task) {
            case Learn -> {

            }
            case Review -> {

            }
            case Qwerty -> {

            }
        }
        return ResponseEntity.internalServerError().body("Unimplemented");
    }

    /**
     * TODO
     * 获取用户对此词典的学习进度，返回 DictProgressVo
     * @param dictId
     * @return
     */
    @GetMapping("/{id}/progress")
    @SaCheckLogin
    public ResponseEntity<?> getProgress(@PathVariable("id") Long dictId) {
        Long userId = StpUtil.getLoginIdAsLong();
        return ResponseEntity.internalServerError().body("Unimplemented");
    }
}
