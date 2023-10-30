package cn.dlut.conspirer.wordhub.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private Long wordId;
    private Long userId;
    private String content;
    private boolean isPublic;
}
