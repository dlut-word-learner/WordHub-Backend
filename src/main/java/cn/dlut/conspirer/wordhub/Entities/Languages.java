package cn.dlut.conspirer.wordhub.Entities;


public enum Languages {
    Test(0),
    English(1),
    Japanese(2);
    private final int value;

    Languages(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
