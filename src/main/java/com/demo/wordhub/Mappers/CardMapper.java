/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
package com.demo.wordhub.Mappers;

import com.demo.wordhub.Entities.Card;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CardMapper {
    @Insert("insert into card(user_id, word_id, card_content, is_public) values (#{userId}, #{wordId}, #{content}, false)")
    int addCard(Card card);

    @Select("select * from card where user_id = #{user_id}")
    @Results(id = "CardsMap", value = {
            @Result(column = "card_id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "word_id", property = "wordId"),
            @Result(column = "is_public", property = "isPublic"),
            @Result(column = "card_content", property = "content")
    })
    List<Card> getCardsByUser(Long user_id);
}
