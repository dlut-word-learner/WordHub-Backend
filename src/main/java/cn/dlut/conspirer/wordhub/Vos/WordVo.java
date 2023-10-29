package cn.dlut.conspirer.wordhub.Vos;

import cn.dlut.conspirer.wordhub.Entities.Word;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Word to return to the frontend
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WordVo {
    Long id;
    String name;
    Long dictId;
    List<String> translations;
    /**
     * 英语：美式发音
     */
    String usPhone;
    /**
     * 英语：英式发音
     */
    String ukPhone;
    /**
     * 日语：汉字（假名）表示
     */
    String notation;
}
