package cn.dlut.conspirer.wordhub.Dtos;

import cn.dlut.conspirer.wordhub.Entities.Word;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WordToReviewDTO extends Word {
    Long tick;
}
