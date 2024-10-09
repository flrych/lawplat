package com.yuchenghao.lawplat.common.enums;
import com.yuchenghao.lawplat.common.api.IResult;

/**
 * Created by yuchenghao on 2024/10/7 21:58.
 */

public enum EResult implements IResult {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或session已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    SYSTEM_ERROR(999, "系统异常，请稍后再试！"),
    EXT_SYSTEM_ERROR(911, "系统异常，请稍后再试！");

    EResult(long code, String message) {
        this.code = code;
        this.message = message;
    }

    private final long code;
    private final String message;

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
