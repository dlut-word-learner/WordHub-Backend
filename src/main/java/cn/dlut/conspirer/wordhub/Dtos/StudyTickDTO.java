package cn.dlut.conspirer.wordhub.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 用来存储Mapper层中的(日期，学习次数)值对
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyTickDTO {
    LocalDate date;
    Long num;
}
