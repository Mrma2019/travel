package top.pymrma.boot.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResultMap<T> extends HashMap<String, Object> {

    public ResultMap() {
        super();
    }

    public ResultMap(ResultEnum resultEnum) {
        this.put(Const.RESP_CODE, resultEnum.getCode());
        this.put(Const.RESP_MSG, resultEnum.getMsg());
    }

    public ResultMap(ResultEnum resultEnum, T data) {
        this.put(Const.RESP_CODE, resultEnum.getCode());
        this.put(Const.RESP_MSG, resultEnum.getMsg());
        this.put(Const.RESP_DATA, data);
    }
}
