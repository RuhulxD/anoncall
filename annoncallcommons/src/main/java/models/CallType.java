package models;

public enum CallType {
    RELAY(1),
    HOST(2),
    SRFLX(3),
    P2P(4);
    private int val;
    
    CallType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
