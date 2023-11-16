package cn.dlut.conspirer.wordhub.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * TODO
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
