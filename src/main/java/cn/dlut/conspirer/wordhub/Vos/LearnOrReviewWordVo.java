package cn.dlut.conspirer.wordhub.Vos;

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
public class LearnOrReviewWordVo {
    Long wordId;
    // 通过几次做题完成学习
    Long studyCount;
}
