package top.pymrma.boot.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultMap<T> extends HashMap {
    private int code;
    private String msg;
    private T data;

    public ResultMap() {

    }

    public ResultMap(Map map) {
        this.putAll(map);
    }

    public ResultMap(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultMap(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
