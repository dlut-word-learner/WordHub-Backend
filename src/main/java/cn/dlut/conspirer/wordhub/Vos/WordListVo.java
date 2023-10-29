package cn.dlut.conspirer.wordhub.Vos;

import cn.dlut.conspirer.wordhub.Entities.Word;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * WordList to return to the frontend to learn or review
 *
 * @author OuOu
 * @version 1.1
 */
@Data
@AllArgsConstructor
public class WordListVo {
    List<WordVo> words;
}
