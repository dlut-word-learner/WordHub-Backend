package cn.dlut.conspirer.wordhub.Vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示当前单词如果点击hard, good, easy分别会安排在多少天后复习
 *
 * @author OuOu
 * @version 1.0
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WordReviewPeekVo {
    Long hard;
    Long good;
    Long easy;
}
