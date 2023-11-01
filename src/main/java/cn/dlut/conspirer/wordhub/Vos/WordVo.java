package cn.dlut.conspirer.wordhub.Vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class WordVo {
    Long id;
    String name;
//    Long dictId;
// 暂时不让extension与其它字段平级
//    @JsonUnwrapped
    WordExtensionVo extension;
}
