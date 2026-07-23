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
    public ResultMap<String> createUser(@RequestBody User user) {
        boolean created = userService.createUser(user);
        return created ? new ResultMap<>(ResultEnum.SUCCESS) : new ResultMap<>(ResultEnum.DATABASE_ERROR);
    }

    //全部用户
    @PostMapping("query/all")
    public ResultMap<PageResult> queryAllUser(@RequestBody PageQueryDTO queryDTO) {
        return new ResultMap<>(ResultEnum.SUCCESS, userService.queryAllUser(queryDTO.toPageable()));
    }
}
