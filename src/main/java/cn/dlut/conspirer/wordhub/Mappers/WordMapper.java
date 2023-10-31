/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * Mapper related to words.
 *
 * @author OuOu2021
 * @version 1.0
 */
@Mapper
public interface WordMapper {
    /**
     * Add a word without its meanings(translations) to a dict.
     *
     * @param word to be added
     * @return 1 if succeeded, 0 if failed
     */
    @Insert("insert into word(word_name, dict_id, extension) values(#{name}, #{dictId}, #{extension, typeHandler=cn.dlut.conspirer.wordhub.Handlers.JsonNodeTypeHandler})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "word_id")
    int addWordToDict(Long dictId, Word word);

    /**
     * Add a translation for a word.
     *
     * @param word  to add translations
     * @param trans translation to be added
     * @return 1 if succeeded, 0 if failed
     */
//    @Insert("insert into word_trans(word_id, trans) values (#{word.id}, #{trans})")
//    int addTransForWord(Word word, String trans);

    /**
     * Add a translation for a word.
     *
     * @param id    the id of the word to add translations
     * @param trans translation to be added
     * @return 1 if succeeded, 0 if failed
     */
//    @Insert("insert into word_trans(word_id, trans) values (#{id}, #{trans})")
//    int addTransByWordId(Long id, String trans);

    /**
     * Get translations of a word by its id.
     *
     * @param id the id of the word
     * @return the meanings(translations) of the word
     */
//    @Select("select trans from word_trans where word_id = #{id}")
//    List<String> getTranslationsByWordId(Long id);
}
