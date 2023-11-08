package cn.dlut.conspirer.wordhub.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyRec {
    Long id;
    Long wordId;
    Long userId;
    /** 上次复习间隔，单位: 天 */
    Long gap;
    /** 难度系数 */
    Double ease;
    /** dueTime 规划本次时间 */
    Timestamp dueTime;
    /** 复习次数 */
    Long tick;
}
