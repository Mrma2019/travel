package top.pymrma.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.pymrma.boot.entity.User;

@Data
@AllArgsConstructor
public class LoginVO {
    private String token;

    private User user;


}
