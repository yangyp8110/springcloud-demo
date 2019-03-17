package com.springcloud.singlehystrix.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mr.yang on 2019/3/17.
 */
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handlerException(Exception e){
        return e.toString();
    }
}
