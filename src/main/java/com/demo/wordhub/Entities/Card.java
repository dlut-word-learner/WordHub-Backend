package com.demo.wordhub.Entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@Data
public class Card {
    private Long id;
    private Long word_id;
    private Long user_id;
    private String content;
    private boolean is_public;
}
