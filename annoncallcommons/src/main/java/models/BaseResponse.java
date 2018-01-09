package models;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    private int rc;

    public BaseResponse() {
        rc = 0;
    }

    public BaseResponse(int rc) {
        this.rc = rc;
    }

    public int getReasonCode() {
        return rc;
    }

    public void setReasonCode(int reasonCode) {
        this.rc = reasonCode;
    }
}
