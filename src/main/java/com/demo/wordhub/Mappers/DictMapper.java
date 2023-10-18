/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.Dict;
import com.demo.wordhub.Entities.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DictMapper {
    @Select("select * from word where dict_id = #{dictId}")
    @Results(id="wordMap", value = {
        @Result(property = "id", column = "word_id"),
        @Result(property = "name", column = "word_name"),
        @Result(property = "dictId", column = "dict_id"),
        @Result(property = "translations", column = "word_id",
            many=@Many(select = "com.demo.wordhub.Mappers.WordMapper.getTranslationsByWordId")),
    })
    List<Word> getWordsByDictId(Long dictId);

    @Select("select lang_id from dict where dict_id = #{dictId}")
    Long getLanguageIdByDictId(Long dictId);

    @Select("select * from dict where dict_name=#{name}")
    Dict getDictByName(String name);
}
