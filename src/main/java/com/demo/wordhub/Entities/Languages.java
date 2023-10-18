package com.demo.wordhub.Entities;

import lombok.Getter;

@Getter
public enum Languages {
    English(1),
    Japanese(2);

    private final int value;

    Languages(int value){
        this.value=value;
    }
}
