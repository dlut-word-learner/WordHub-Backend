package cn.dlut.conspirer.wordhub.Entities;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Word实体类包括id, name, 字典id，以及扩展信息
 * 扩展信息包括:
 * <ul>
 *     <li>usphone: 美式发音</li>
 *     <li>ukphone: 英式发音</li>
 *     <li>trans: 含义，json数组</>
 *     <li>notation: 汉字(假名表示)</li>
 * </ul>
 *
 * @author OuOu
 * @version 1.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    Long id;
    String name;
    Long dictId;
    JsonNode extension;
}
