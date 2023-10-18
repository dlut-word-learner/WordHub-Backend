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
public class Dict {
    Long id;
    Languages language;
    String name;
    List<Word> wordList;

    public Dict(Languages language, String name) {
        this.language = language;
        this.name = name;
    }
}
