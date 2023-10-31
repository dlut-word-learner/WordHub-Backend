package cn.dlut.conspirer.wordhub.Mappers;
import cn.dlut.conspirer.wordhub.Entities.Card;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import cn.dlut.conspirer.wordhub.WordHubApplication;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@ContextConfiguration(classes = WordHubApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Slf4j
/**
 * TODO
 * new file for test
 * org.springframework.dao.DataIntegrityViolationException:
 * there are something wrong??
 */

public class CardMapperTest {
    @Autowired
    CardMapper cardMapper;
    Card getTestCard() {
        return new Card(1005L,1000001L,1000001L,"test",true);
    }
    @Test
    @Order(1)
    void testAddCard(){
        Card testCard = getTestCard();
        int lines = cardMapper.addCard(testCard);
        assertEquals(1,lines);
    }

    @Test
    @Order(2)
    @Sql("/data-testGetCardsByUser.sql")
    void testGetCardsByUser(){
        Card card = getTestCard();
        cardMapper.addCard(card);
        List<Card> testCard = cardMapper.getCardsByUser(card.getUserId());
        assertThat(testCard).extracting(Card::getContent).contains("test");
    }


}