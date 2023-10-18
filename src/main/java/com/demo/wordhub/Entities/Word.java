package com.demo.wordhub.Entities;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@Data
public class Word {
    Long id;
    String name;
    Long dictId;
    List<String> translations;
}
