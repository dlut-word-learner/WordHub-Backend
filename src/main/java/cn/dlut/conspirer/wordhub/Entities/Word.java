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
public class Word {
    Long id;
    String name;
    Long dictId;
    List<String> translations;
}
