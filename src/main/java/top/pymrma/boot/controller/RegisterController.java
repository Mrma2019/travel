package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.dto.RegisterDTO;
import top.pymrma.boot.services.impl.UserServiceImpl;

@RestController
@RequestMapping("register")
@RequiredArgsConstructor
public class RegisterController {
    private final UserServiceImpl userService;

    //用户注册
    @PostMapping
    public ResultMap<String> register(@RequestBody RegisterDTO dto) {
        if (!userService.isExists(dto.getEmail())) {
            userService.register(dto);
            return new ResultMap<>(ResultEnum.SUCCESS);
        }
        return new ResultMap<>(ResultEnum.USER_EXIST);
    }
}
