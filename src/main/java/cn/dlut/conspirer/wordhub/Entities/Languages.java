package cn.dlut.conspirer.wordhub.Entities;


import lombok.Getter;

@Getter
public enum Languages {
    Test(0),
    English(1),
    Japanese(2);
    private final int value;

    Languages(int value) {
        this.value = value;
    }

}