package cn.dlut.conspirer.wordhub.Services;

import cn.dlut.conspirer.wordhub.Entities.Card;
import cn.dlut.conspirer.wordhub.Entities.CardResponse;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
public interface CardService {
    void addCard(Card card);

    List<Card> getCardsByUser(Long user_id);

    Card getCardById(Long cardId);

    List<CardResponse> getResponseByCardId(Long cardId);

    void addCardResponse(CardResponse response);

    void editCardContent(Long cardId, String content);

    void setPublic(Long cardId, boolean isPublic);
}
