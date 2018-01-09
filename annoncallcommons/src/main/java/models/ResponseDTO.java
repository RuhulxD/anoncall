package models;

public class ResponseDTO<T> extends BaseResponse {
    private T t;

    public ResponseDTO() {
        super();
    }

    public ResponseDTO(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
