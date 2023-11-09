package cn.dlut.conspirer.wordhub.Vos;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WordToReviewVo extends WordVo{
    Long tick;
}
