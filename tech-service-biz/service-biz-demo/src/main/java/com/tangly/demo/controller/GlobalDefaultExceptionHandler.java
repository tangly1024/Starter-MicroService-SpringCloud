package com.tangly.demo.controller;

import com.tangly.demo.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request, Exception e) {
        log.error(e.getMessage());
        return e.getMessage();
    }

    //声明要捕获的异常
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public String baseExceptionHandler(HttpServletRequest request, BaseException e) {
        log.error(e.getMessage() + " " + e.getMsg());
        return e.getMessage();
    }

}