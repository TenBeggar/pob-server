package com.tenbeggar.pob.config;

import com.tenbeggar.pob.utils.RestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public RestVO<Void> runtimeException(RuntimeException e) {
        log.error("【统一异常处理】RuntimeException:", e);
        return RestVO.ERROR(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RestVO<Void> exceptionHandler(Exception e) {
        log.error("【统一异常处理】Exception:", e);
        return RestVO.ERROR(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
