/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Handlers.LanguagesTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface DictMapper {
    @Select("select * from word where dict_id = #{dictId}")
    @Results(id = "wordMap", value = {
            @Result(property = "id", column = "word_id"),
            @Result(property = "name", column = "word_name"),
            @Result(property = "dictId", column = "dict_id"),
            @Result(property = "translations", column = "word_id",
                    many = @Many(select = "cn.dlut.conspirer.wordhub.Mappers.WordMapper.getTranslationsByWordId")),
    })
    List<Word> getWordsByDictId(Long dictId);

    @Select("select lang_id from dict where dict_id = #{dictId}")
    Long getLanguageIdByDictId(Long dictId);

    @Select("select * from dict where dict_name=#{name}")
    @Results(id = "dictMap", value = {
            @Result(property = "id", column = "dict_id"),
            @Result(property = "language", column = "lang_id", jdbcType = JdbcType.INTEGER, typeHandler = LanguagesTypeHandler.class),
            @Result(property = "name", column = "dict_name"),
    })
    Dict getDictByName(String name);

    @Select("select * from dict where dict_id=#{id}")
    @ResultMap("dictMap")
    Dict getDictById(Long id);

    @Select("select * from dict")
    @ResultMap("dictMap")
    List<Dict> getDicts();
}
