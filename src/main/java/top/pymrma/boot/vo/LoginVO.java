package top.pymrma.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.pymrma.boot.entity.User;


public record LoginVO(
        String token,
        UserVO userVO
) {
}
