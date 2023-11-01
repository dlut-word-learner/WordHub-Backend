/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Handlers.JsonNodeTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DictMapper {
    @Select("select * from word where dict_id = #{dictId}")
    @Results(id = "wordMap", value = {
            @Result(property = "id", column = "word_id"),
            @Result(property = "name", column = "word_name"),
            @Result(property = "extension", column = "extension", typeHandler = JsonNodeTypeHandler.class)
    })
    List<Word> getWordsByDictId(Long dictId);

    @Select("select lang_name from dict where dict_id = #{dictId}")
    Languages getLanguageByDictId(Long dictId);

    @Select("select * from dict where dict_name=#{name}")
    @Results(id = "dictMap", value = {
            @Result(property = "id", column = "dict_id"),
//            @Result(property = "language", column = "lang_id", jdbcType = JdbcType.INTEGER, typeHandler = LanguagesTypeHandler.class),
            @Result(property = "name", column = "dict_name"),
            @Result(property = "language", column = "lang_name"),
    })
    Dict getDictByName(String name);

    @Select("select * from dict where dict_id=#{id}")
    @ResultMap("dictMap")
    Dict getDictById(Long id);

    @Select("select * from dict")
    @ResultMap("dictMap")
    List<Dict> getDicts();

    @Select("select word.word_id, word_name, extension from word " +
    "left join (select distinct word_id from study_rec " +
    "where user_id = #{userId}) as sr " +
    "on word.word_id = sr.word_id " +
    "where word.dict_id = #{dictId} and sr.word_id is null " +
    "limit #{num}")
    @ResultMap("wordMap")
    List<Word> getWordsToLearn(Long dictId, Long userId, Long num);

    @Insert("insert into dict(lang_name, dict_name) values(#{language}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "dict_id")
    int addDict(Dict dict);
}
