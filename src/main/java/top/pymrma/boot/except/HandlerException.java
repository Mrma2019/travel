package top.pymrma.boot.except;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;

@RestControllerAdvice
@Slf4j
public class HandlerException {
    //用户不存在
    @ExceptionHandler
    public ResultMap<String> handlerException(UsernameNotFoundException e) {
        log.error(e.getMessage());
        return new ResultMap<>(ResultEnum.USER_NOT_FOUND, e.getMessage());
    }

    //邮箱或密码错误
    @ExceptionHandler
    public ResultMap<String> handlerException(BadCredentialsException e) {
        return new ResultMap<>(ResultEnum.LOGIN_FAILED, e.getMessage());
    }

    @ExceptionHandler
    public ResultMap<String> handlerException(HttpRequestMethodNotSupportedException e) {
        return new ResultMap<>(ResultEnum.METHOD_NOT_ALLOWED, e.getMessage());
    }

    @ExceptionHandler
    public ResultMap<String> handlerException(HttpMessageNotReadableException e) {
        return new ResultMap<>(ResultEnum.PARAM_ERROR, e.getMessage());
    }

    @ExceptionHandler
    public ResultMap<String> handlerException(MaxUploadSizeExceededException e) {
        return new ResultMap<>(ResultEnum.FILE_UPLOAD_ERROR, e.getMessage());
    }

    @ExceptionHandler
    public ResultMap<String> handlerException(FileNotFoundException e) {
        return new ResultMap<>(ResultEnum.FILE_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler
    public ResultMap<String> handlerException(NoSuchFileException e) {
        return new ResultMap<>(ResultEnum.FILE_NOT_FOUND);
    }
}
