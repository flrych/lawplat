package com.yuchenghao.lawplat.common.api;

/**
 * 断言处理类，用于抛出逻辑异常
 * Created by yuchenghao on 2024/10/7 22:10.
 */
public class Asserts {
    public static void fail(String message) {
        throw new RuntimeException(message);
    }
}
