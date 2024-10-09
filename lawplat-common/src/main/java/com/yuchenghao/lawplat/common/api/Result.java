package com.yuchenghao.lawplat.common.api;

import com.yuchenghao.lawplat.common.enums.EResult;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by yuchenghao on 2024/10/7 22:27.
 */
@Getter
@Setter
public class Result<T> {

    private long code;
    private String message;
    private Object data;

    protected Result() {}

    protected Result(long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(Object data) {
        return new Result<T>(EResult.SUCCESS.getCode(), EResult.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(Object data, String message) {
        return new Result<T>(EResult.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> failed(IResult result) {
        return new Result<T>(result.getCode(), result.getMessage(), null);
    }

    public static <T> Result<T> failed(IResult result, String message) {
        return new Result<T>(result.getCode(), message, null);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<T>(EResult.FAILED.getCode(), message, null);
    }

    public static <T> Result<T> failed() {
        return failed(EResult.FAILED);
    }

    public static <T> Result<T> validateFailed() {
        return failed(EResult.VALIDATE_FAILED);
    }

    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(EResult.VALIDATE_FAILED.getCode(), message, null);
    }

}
