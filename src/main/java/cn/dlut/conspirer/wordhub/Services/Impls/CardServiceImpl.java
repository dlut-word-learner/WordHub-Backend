package cn.dlut.conspirer.wordhub.Services.Impls;

import cn.dlut.conspirer.wordhub.Entities.Card;
import cn.dlut.conspirer.wordhub.Entities.CardResponse;
import cn.dlut.conspirer.wordhub.Mappers.CardMapper;
import cn.dlut.conspirer.wordhub.Services.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@Service
public class CardServiceImpl implements CardService {
    CardMapper cardMapper;

    @Autowired
    CardServiceImpl(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    @Override
    public void addCard(Card card) {
        cardMapper.addCard(card);
    }

    @Override
    public List<Card> getCardsByUser(Long userId) {
        return cardMapper.getCardsByUser(userId);
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardMapper.getCardById(cardId);
    }

    @Override
    public List<CardResponse> getResponseByCardId(Long cardId) {
        return cardMapper.getResponseByCardId(cardId);
    }

    @Override
    public void addCardResponse(CardResponse response) {
        cardMapper.addCardResponse(response);
    }

    @Override
    public void editCardContent(Long cardId, String content) {
        cardMapper.editCardContent(cardId, content);
    }

    @Override
    public void setPublic(Long cardId, boolean isPublic) {
        cardMapper.setPublic(cardId, isPublic);
    }
}
