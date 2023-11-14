/**
 * Dict以及从Dict里拿词相关的JDBC逻辑
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

    @Select("SELECT word.word_id, word.word_name, word.extension, study_rec.study_rec_tick FROM word " +
            "JOIN ( " +
            "    SELECT word_id, MAX(study_rec_tick) AS tick " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "              ON word.word_id = latest_study_rec.word_id " +
            "         JOIN study_rec " +
            "              ON latest_study_rec.word_id = study_rec.word_id " +
            "              AND latest_study_rec.tick = study_rec.study_rec_tick " +
            "WHERE word.dict_id = #{dictId} " +
            "      AND DATE(study_rec.study_rec_due_time) <= CURRENT_DATE " +
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

    @Select("SELECT count(*) FROM word " +
            "JOIN ( " +
            "    SELECT word_id, MAX(study_rec_tick) AS tick " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "              ON word.word_id = latest_study_rec.word_id " +
            "         JOIN study_rec " +
            "              ON latest_study_rec.word_id = study_rec.word_id " +
            "              AND latest_study_rec.tick = study_rec.study_rec_tick " +
            "WHERE word.dict_id = #{dictId} " +
            "      AND DATE(study_rec.study_rec_due_time) <= CURRENT_DATE;")
    Long getWordNumToReview(Long dictId, Long userId);

    @Select("select word.word_id, word_name, extension from word " +
            "where word.dict_id = #{dictId} " +
            "order by rand()" +
            "limit #{num}")
    @ResultMap("wordMap")
    List<Word> getWordsToQwerty(Long dictId, Long num);

    @Insert("insert into dict(lang_name, dict_name) values(#{language}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "dict_id")
    Long addDict(Dict dict);

    @Select("select * from dict where lang_name = #{lang}")
    @ResultMap("dictMap")
    List<Dict> getDictsByLanguage(Languages lang);

    @Select("SELECT count(*) " +
            "FROM word " +
            "JOIN ( " +
            "    SELECT word_id, MAX(study_rec_due_time) AS due_time " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "ON word.word_id = latest_study_rec.word_id " +
            "JOIN study_rec " +
            "ON latest_study_rec.word_id = study_rec.word_id " +
            "AND latest_study_rec.due_time = study_rec.study_rec_due_time " +
            "WHERE word.dict_id = #{dictId} " +
            "AND DATE(study_rec.study_rec_due_time) >= DATE(timestampadd(month, 1, CURRENT_DATE));")
    Long getNumMastered(Long dictId, Long userId);

    @Select("SELECT count(*) " +
            "FROM word " +
            "JOIN ( " +
            "    SELECT word_id, MAX(study_rec_due_time) AS due_time " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "ON word.word_id = latest_study_rec.word_id " +
            "JOIN study_rec " +
            "ON latest_study_rec.word_id = study_rec.word_id " +
            "AND latest_study_rec.due_time = study_rec.study_rec_due_time " +
            "WHERE word.dict_id = #{dictId} " +
            "AND DATE(study_rec.study_rec_due_time) < DATE(timestampadd(month, 1, CURRENT_DATE));")
    Long getNumUnmastered(Long dictId, Long userId);

    @Select("SELECT count(*) FROM word " +
            "WHERE word.dict_id = #{dictId};")
    Long getWordNum(Long dictId);

    /**
     * QwertyRec 表中添加一条 Qwerty 记录，只需要插入本次 Qwerty 了多少个词，不需要存是哪一些词。 QwertyRec 表需要有id作为主键。一个 userId 与一个 dictId 在 QwertyRec 表可以有多个字段
     * 前端完成 Qwerty 时一次上传即可
     * @param dictId
     * @param userId
     * @param n 本次Qwerty完成的单词数量
     * @return
     */
    @Insert("insert into qwerty_rec(qwerty_rec_time, user_id, dict_id, qwerty_num) values(current_timestamp, #{userId}, #{dictId}, #{n})")
    Long insertQwertyRec(Long dictId, Long userId, Long n);
}