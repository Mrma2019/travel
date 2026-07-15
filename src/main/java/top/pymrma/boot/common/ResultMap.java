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

    public ResultMap(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ResultMap(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }
}
