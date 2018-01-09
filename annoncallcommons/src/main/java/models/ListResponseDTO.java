package models;

import java.util.Collections;
import java.util.List;

public class ListResponseDTO<T> extends BaseResponse {
    private List<T> t;

    public ListResponseDTO() {
        super();
        t= Collections.emptyList();
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }
}
