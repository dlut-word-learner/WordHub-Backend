package cn.dlut.conspirer.wordhub.Controllers;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Services.DictService;
import cn.dlut.conspirer.wordhub.Vos.DictVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles requests related to the Dict entity.
 *
 * @author OuOu
 * @version 1.0
 */
@RestController
@RequestMapping("/dicts")
public class DictController {
    DictService dictService;

    @Autowired
    DictController(DictService dictService){
        this.dictService=dictService;
    }

    @GetMapping
    public List<DictVo> getAllDictionaries(){
        return dictService.getAllDictionaries().stream().map(x -> {
            DictVo dictVo = new DictVo();
            BeanUtils.copyProperties(x, dictVo);
            return dictVo;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DictVo getDictionary(@PathVariable("id") Long dictId){
        Dict dict = dictService.getDictionaryById(dictId);
        DictVo dictVo = new DictVo();
        BeanUtils.copyProperties(dict, dictVo);
        return dictVo;
    }
}
