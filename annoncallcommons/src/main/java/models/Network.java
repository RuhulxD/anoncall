package models;

public enum Network {
    WIFI(1),
    GSM2G(2),
    GSM3G(3),
    GSM4G(4),
    GSM5G(5),
    GSM_EGDE(6),
    GSM_GPRS(7);

    private  int val;
    Network(int val){
        this.val = val;
    }
    public int getVal(){
        return val;
    }
}
