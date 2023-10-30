package cn.dlut.conspirer.wordhub.Entities;

import lombok.AllArgsConstructor;
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
