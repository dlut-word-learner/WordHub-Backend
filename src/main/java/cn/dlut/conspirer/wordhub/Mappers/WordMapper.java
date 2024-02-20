// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

/**
 * （单个）单词相关JDBC逻辑
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.StudyRec;
import cn.dlut.conspirer.wordhub.Entities.Word;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

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
    @Insert("insert into word(word_name, dict_id, extension) values(#{word.name}, #{dictId}, #{word.extension, typeHandler=cn.dlut.conspirer.wordhub.Handlers.JsonNodeTypeHandler})")
    @Options(useGeneratedKeys = true, keyProperty = "word.id", keyColumn = "word_id")
    int addWordToDict(Long dictId, Word word);
//TODO for two
    @Insert("insert into study_rec(word_id, user_id, study_rec_tick, study_rec_gap, study_rec_due_time, study_rec_ease) " +
            "values(#{wordId}, #{userId}, #{tick}, #{gap}, #{dueTime}, #{ease})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "study_rec_id")
    int insertStudyRec(Long userId, Long wordId, Long tick, Long gap, Timestamp dueTime, Double ease);

    @Select("select * from study_rec where user_id=#{userId} and word_id=#{wordId} ORDER BY study_rec_due_time DESC LIMIT 1")
    @Results(id = "StudyRecMap", value = {
            @Result(column = "study_rec_id", property = "id"),
            @Result(column = "word_id", property = "wordId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "study_rec_gap", property = "gap"),
            @Result(column = "study_rec_ease", property = "ease"),
            @Result(column = "study_rec_due_time", property = "dueTime"),
            @Result(column = "study_rec_tick", property = "tick"),
    })
    StudyRec getLatestStudyRec(Long userId, Long wordId);
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
