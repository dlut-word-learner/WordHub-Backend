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
    private Long wordId;
    private Long userId;
    private String content;
    private boolean isPublic;
}
