package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.dto.PageQueryDTO;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    //添加用户
    @PostMapping("add")
    public ResultMap createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResultMap<>(ResultEnum.SUCCESS);
    }

    //全部用户
    @GetMapping("all")
    public ResultMap queryAllUser(@RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(ResultEnum.SUCCESS, userService.queryAllUser(queryDTO.toPageable()));
    }
}
