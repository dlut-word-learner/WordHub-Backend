/**
 * 目前进度用不到这个类
 *
 * @author OuOu
 * @version 1.0
 */
package cn.dlut.conspirer.wordhub.Mappers;

import cn.dlut.conspirer.wordhub.Entities.Card;
import cn.dlut.conspirer.wordhub.Entities.CardResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CardMapper {
    @Insert("insert into card(user_id, word_id, card_content, is_public) values (#{userId}, #{wordId}, #{content}, #{isPublic})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "card_id")
    int addCard(Card card);

    @Select("select * from card where user_id = #{user_id}")
    @Results(id = "cardMap", value = {
            @Result(column = "card_id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "word_id", property = "wordId"),
            @Result(column = "is_public", property = "isPublic"),
            @Result(column = "card_content", property = "content")
    })
    List<Card> getCardsByUser(Long user_id);

    @Select("select * from card where card_id = #{cardId}")
    @ResultMap("cardMap")
    Card getCardById(Long cardId);

    @Insert("insert into card_response(card_id, user_id, card_response_type, card_response_content) values (#{cardId}, #{userId}, #{type}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "card_response_id")
    int addCardResponse(CardResponse response);

    @Select("select * from card_response where card_id = #{cardId}")
    @Results(id = "cardResponseMap", value = {
            @Result(column = "card_response_id", property = "id"),
            @Result(column = "card_id", property = "cardId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "card_response_type", property = "type"),
            @Result(column = "card_response_content", property = "content")
    })
    List<CardResponse> getResponseByCardId(Long cardId);

    @Update("update card " +
            "set card_content = #{content} " +
            "where card_id = #{cardId}")
    int editCardContent(Long cardId, String content);

    @Update("update card " +
            "set is_public = #{isPublic} " +
            "where card_id = #{cardId}")
    int setPublic(Long cardId, boolean isPublic);
}
