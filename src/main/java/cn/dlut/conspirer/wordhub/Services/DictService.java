/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.Dict;

import java.util.List;

public interface DictService {
    List<Dict> getAllDictionaries();

    Dict getDictionaryById(Long id);
}
