package models;

public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3),
    UNSPECIFIED(4);

    Gender(int val) {
        this.val = val;
    }

    private int val = 4;

    public int getVal() {
        return this.val;
    }
}
