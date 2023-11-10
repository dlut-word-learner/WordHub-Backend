package cn.dlut.conspirer.wordhub.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一个词典的示例，不包含里面的单词
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dict {
    Long id;
    Languages language;
    String name;

    public Dict(Languages language, String name) {
        this.language = language;
        this.name = name;
    }
}
