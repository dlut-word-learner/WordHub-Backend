/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.Dict;
import com.demo.wordhub.Entities.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordMapper {
    @Insert("insert into word(word_name, dict_id) values(#{name}, #{dictId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "word_id")
    int addWord(Word word);

    @Insert("insert into word_trans(word_id, trans) values (#{word.id}, #{trans})")
    int addTransForWord(Word word, String trans);

    @Insert("insert into word_trans(word_id, trans) values (#{id}, #{trans})")
    int addTransByWordId(Long id, String trans);

    int addWords(Dict dict, List<Word> words);

    @Select("select trans from word_trans where word_id = #{id}")
    List<String> getTranslationsByWordId(Long id);
}
