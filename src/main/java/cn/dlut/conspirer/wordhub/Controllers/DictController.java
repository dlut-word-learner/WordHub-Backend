package cn.dlut.conspirer.wordhub.Controllers;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Services.DictService;
import cn.dlut.conspirer.wordhub.Vos.DictVo;
import cn.dlut.conspirer.wordhub.Vos.WordExtensionVo;
import cn.dlut.conspirer.wordhub.Vos.WordListVo;
import cn.dlut.conspirer.wordhub.Vos.WordVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<DictVo>> getAllDictionaries() {
        return ResponseEntity.ok(dictService.getAllDictionaries().stream().map(x -> {
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
    @GetMapping("/{id}/toLearn")
    @SaCheckLogin
    public ResponseEntity<?> getWordsToLearn(@PathVariable("id") Long dictId, @RequestParam Long num) {
        Long userId = StpUtil.getLoginIdAsLong();
        // Languages lang = dictService.getLanguageByDictId(dictId);
        List<WordVo> wordList = dictService.getWordsToLearn(dictId, userId, num).stream().map(x -> {
//            WordExtensionVo wordExtensionVo = null;
//            try {
//                wordExtensionVo = objectMapper.treeToValue(x.getExtension(), WordExtensionVo.class);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
            return WordVo.builder()
                    .id(x.getId())
                    .name(x.getName())
                    //.extension(x.getExtension())
                    .build();
        }).collect(Collectors.toList());
        return ResponseEntity.ok(new WordListVo(wordList));
    }
}
