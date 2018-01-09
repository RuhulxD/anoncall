package models;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    private int rc;
    private String message;

    public BaseResponse() {
        rc = 0;
    }

    public BaseResponse(int rc, String message) {
        this.rc = rc; this.message = message;
    }

    public int getReasonCode() {
        return rc;
    }

    public void setReasonCode(int reasonCode) {
        this.rc = reasonCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
