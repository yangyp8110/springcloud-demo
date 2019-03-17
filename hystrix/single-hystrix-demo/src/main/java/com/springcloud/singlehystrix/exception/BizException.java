package com.springcloud.singlehystrix.exception;

/**
 * Created by mr.yang on 2019/3/17.
 */
public class BizException extends RuntimeException {
    private Integer code;
    private String message;

    public BizException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
