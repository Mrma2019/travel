package top.pymrma.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;

@Slf4j
@RestController
@RequestMapping("index")
public class HelloController {
    @GetMapping
    public ResultMap<String> index() {
        return new ResultMap<>(ResultEnum.SUCCESS, "测试");
    }
}
