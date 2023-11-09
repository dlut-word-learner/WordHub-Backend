/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Dtos.WordToReviewDTO;
import cn.dlut.conspirer.wordhub.Entities.Dict;
import cn.dlut.conspirer.wordhub.Entities.Languages;
import cn.dlut.conspirer.wordhub.Entities.Word;
import cn.dlut.conspirer.wordhub.Handlers.JsonNodeTypeHandler;
import cn.dlut.conspirer.wordhub.Vos.WordToReviewVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DictMapper {
    @Select("select * from word where dict_id = #{dictId}")
    @Results(id = "wordMap", value = {
            @Result(property = "id", column = "word_id"),
            @Result(property = "name", column = "word_name"),
            @Result(property = "dictId", column = "dict_id"),
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
            "where word.dict_id = #{dictId} and " +
            "word.word_id not in " +
            "(select distinct study_rec.word_id from study_rec where study_rec" +
            ".user_id" +
            " = #{userId}) " +
            "order by rand(#{userId})" +
            "limit #{num}")
    @ResultMap("wordMap")
    List<Word> getWordsToLearn(Long dictId, Long userId, Long num);

    @Select("SELECT word.word_id, word.word_name, word.extension, study_rec.study_rec_tick " +
            "FROM word " +
            "         JOIN ( " +
            "    SELECT word_id, MAX(study_rec_tick) AS tick " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "              ON word.word_id = latest_study_rec.word_id " +
            "         JOIN study_rec " +
            "              ON latest_study_rec.word_id = study_rec.word_id " +
            "                  AND latest_study_rec.tick = study_rec.study_rec_tick " +
            "WHERE word.dict_id = #{dictId} " +
            "      AND DATE(study_rec.study_rec_due_time) <= CURDATE() " +
            "ORDER BY study_rec.study_rec_due_time ASC " +
            "LIMIT #{num};")
    @Results(id="wordToReviewMap",value = {
            @Result(property = "id", column = "word_id"),
            @Result(property = "name", column = "word_name"),
            @Result(property = "dictId", column = "dict_id"),
            @Result(property = "extension", column = "extension", typeHandler = JsonNodeTypeHandler.class),
            @Result(property = "tick", column = "study_rec_tick"),
    })
    List<WordToReviewDTO> getWordsToReview(Long dictId, Long userId, Long num);

    @Insert("insert into dict(lang_name, dict_name) values(#{language}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "dict_id")
    int addDict(Dict dict);

    @Select("select * from dict where lang_name = #{lang}")
    @ResultMap("dictMap")
    List<Dict> getDictsByLanguage(Languages lang);
}
