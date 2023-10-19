package cn.dlut.conspirer.wordhub.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class Dict {
    Long id;
    Languages language;
    String name;
    List<Word> wordList;

    public Dict(Languages language, String name) {
        this.language = language;
        this.name = name;
    }
}
