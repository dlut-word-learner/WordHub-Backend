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

    @Select("select word.word_id, word_name, extension from word " +
            "where word.dict_id = #{dictId} " +
            "order by rand()" +
            "limit #{num}")
    @ResultMap("wordMap")
    List<Word> getWordsToQwerty(Long dictId, Long num);

    @Insert("insert into dict(lang_name, dict_name) values(#{language}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "dict_id")
    int addDict(Dict dict);

    @Select("select * from dict where lang_name = #{lang}")
    @ResultMap("dictMap")
    List<Dict> getDictsByLanguage(Languages lang);

    @Select("SELECT count(*) " +
            "FROM word " +
            "JOIN ( " +
            "    SELECT word_id, MAX(due_time) AS due_time " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "ON word.word_id = latest_study_rec.word_id " +
            "JOIN study_rec " +
            "ON latest_study_rec.word_id = study_rec.word_id " +
            "AND latest_study_rec.due_time = study_rec.due_time " +
            "WHERE word.dict_id = #{dictId} " +
            "AND DATE(study_rec.due_time) <= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);")
    Long getMasteredNum(Long dictId, Long userId);

    @Select("SELECT count(*) " +
            "FROM word " +
            "JOIN ( " +
            "    SELECT word_id, MAX(due_time) AS due_time " +
            "    FROM study_rec " +
            "    WHERE user_id = #{userId} " +
            "    GROUP BY word_id " +
            ") AS latest_study_rec " +
            "ON word.word_id = latest_study_rec.word_id " +
            "JOIN study_rec " +
            "ON latest_study_rec.word_id = study_rec.word_id " +
            "AND latest_study_rec.due_time = study_rec.due_time " +
            "WHERE word.dict_id = #{dictId} " +
            "AND DATE(study_rec.due_time) > DATE_SUB(CURDATE(), INTERVAL 1 MONTH);")
    Long getNumUnmastered(Long dictId, Long userId);

    @Select("SELECT count(*) FROM word " +
            "WHERE word.dict_id = #{dictId};")
    Long getWordNum(Long dictId);


    /**
     * TODO
     * 返回用户过去n天学习的单词数量
     * sql大意：从StudyRec表中选出最早一次学习记录(tick=1)在n天之内的单词，count(*) group by date
     * @param dictId
     * @param userId
     * @param n
     * @return
     */
    Long getLearnTickInPastNDays(Long dictId, Long userId, Long n);

    /**
     * TODO
     * 返回用户过去n天复习单词次数
     * sql大意：从StudyRec表中选出n天之内的学习记录，where tick!=1(排除学习)，count(*) group by date
     * @param dictId
     * @param userId
     * @param n
     * @return
     */
    Long getReviewTickInPastNDays(Long dictId, Long userId, Long n);

    /**
     * TODO
     * 返回用户过去n天Qwerty单词次数
     * 考虑建一个新表专门存Qwerty的历史记录，可以叫QwertyRec，因为这个记录和StudyRec的机制有很大差别
     * @param dictId
     * @param userId
     * @param n
     * @return
     */
    Long getQwertiyTickInPastNDays(Long dictId, Long userId, Long n);

    /**
     * TODO
     * QwertyRec表中添加一条Qwerty记录，只需要插入本次Qwerty了多少个词，不需要存是哪一些词。QwertyRec表需要有id作为主键。一个userId与一个dictId在QwertyRec表可以有多个字段
     * 前端完成Qwerty时一次上传即可
     * @param dictId
     * @param userId
     * @param n 本次Qwerty完成的单词数量
     * @return
     */
    Long insertQwertyRec(Long dictId, Long userId, Long n);
}