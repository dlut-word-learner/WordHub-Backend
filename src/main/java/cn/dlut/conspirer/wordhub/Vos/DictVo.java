package cn.dlut.conspirer.wordhub.Vos;

import cn.dlut.conspirer.wordhub.Entities.Languages;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dict to return to the frontend
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class DictVo {
    Long Id;
    Languages language;
    String name;
}
