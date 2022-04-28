package com.amos.think.web;

import com.alibaba.cola.dto.Response;
import com.amos.think.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liudongjin
 * @date 2022/4/28 14:41
 * @description 统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Response handleBizException(BizException e) {
        log.error("BizException:", e);
        return Response.buildFailure(e.getErrorCode().toString(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("Exception:", e);
        return Response.buildFailure("500", e.getMessage());
    }
}
