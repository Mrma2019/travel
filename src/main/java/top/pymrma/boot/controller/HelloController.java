package top.pymrma.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.ResultMap;

@RestController
@RequestMapping("index")
public class HelloController {
    @GetMapping
    public ResultMap index() {
        return null;
    }
}
