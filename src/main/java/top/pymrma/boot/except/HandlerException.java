package top.pymrma.boot.except;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;

@RestControllerAdvice
@Slf4j
public class HandlerException {
    @ExceptionHandler()
    public ResultMap handlerException(Exception e) {
        log.error(e.getMessage());
        return new ResultMap(ResultEnum.SYSTEM_ERROR, e.getMessage());
    }
}
