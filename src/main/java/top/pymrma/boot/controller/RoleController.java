package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.entity.Role;
import top.pymrma.boot.services.RoleService;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("add")
    public ResultMap role(@RequestBody Role role) {
        roleService.createRole(role);
        return new ResultMap(ResultEnum.SUCCESS);
    }
}
