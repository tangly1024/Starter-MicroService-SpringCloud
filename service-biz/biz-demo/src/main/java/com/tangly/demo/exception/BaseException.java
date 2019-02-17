package com.tangly.demo.exception;

import com.tangly.demo.enums.ResultEnum;
import lombok.*;

/**
 * 演示异常
 */
@Getter
@Setter
@ToString
public class BaseException extends RuntimeException {

    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 补充描述
     */
    private String msg;

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public BaseException(ResultEnum resultEnum, String msg) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.msg = msg;
    }
}
