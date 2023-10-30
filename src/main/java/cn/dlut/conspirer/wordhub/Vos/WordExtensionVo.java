package cn.dlut.conspirer.wordhub.Vos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Extension field of WordVo
 *
 * @author OuOu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WordExtensionVo {
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
