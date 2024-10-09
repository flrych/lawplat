package com.yuchenghao.lawplat.web.modules;

import com.yuchenghao.lawplat.common.api.IResult;
import com.yuchenghao.lawplat.common.api.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yuchenghao on 2024/10/8 23:57.
 */
@Slf4j
public class BaseController<T> {

    protected static final Result<?> SUCCESS =  Result.success(null);

    protected static final Result<?> FAIL =  Result.failed();

    protected Result<T> error(IResult iResult){
        return Result.failed(iResult);
    }

    protected Result<T> success(Object data) {
        return Result.success(data);
    }
}
