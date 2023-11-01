package cn.dlut.conspirer.wordhub.Entities;

import com.fasterxml.jackson.annotation.JsonKey;
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
public class CardResponse {
    Long id;
    Long cardId;
    Long userId;
    CardResponseType type;
    String content;
}
