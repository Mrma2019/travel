package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.services.UserService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //添加用户
    @PostMapping("add")
    public ResultMap addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }
}
