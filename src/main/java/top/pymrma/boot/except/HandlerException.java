package top.pymrma.boot.except;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;

@RestControllerAdvice
@Slf4j
public class HandlerException {
    @ExceptionHandler
    public ResultMap handlerException(UsernameNotFoundException e) {
        log.error(e.getMessage());
        return new ResultMap<>(ResultEnum.USER_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler
    public ResultMap handlerException(BadCredentialsException e) {
        return new ResultMap<>(ResultEnum.LOGIN_FAILED);
    }

    @ExceptionHandler
    public ResultMap handlerException(HttpRequestMethodNotSupportedException e) {
        return new ResultMap<>(ResultEnum.METHOD_NOT_ALLOWED);
    }
}
