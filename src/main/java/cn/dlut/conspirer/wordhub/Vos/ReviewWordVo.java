package cn.dlut.conspirer.wordhub.Vos;

import cn.dlut.conspirer.wordhub.Entities.SchedulingStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewWordVo {
    SchedulingStates rating;
    Long tick;
}
