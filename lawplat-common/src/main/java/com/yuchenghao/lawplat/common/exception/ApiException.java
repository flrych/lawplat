package com.yuchenghao.lawplat.common.exception;

import com.yuchenghao.lawplat.common.api.IResult;
import lombok.Getter;

/**
 * 自定义异常类
 * Created by yuchenghao on 2024/10/7 22:12.
 */
@Getter
public class ApiException extends Exception{

    private IResult result;

    public ApiException(IResult result) {
        super(result.getMessage());
        this.result = result;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
