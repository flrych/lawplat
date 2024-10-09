package com.yuchenghao.lawplat.common.exception;

import com.yuchenghao.lawplat.common.api.Result;
import com.yuchenghao.lawplat.common.enums.EResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 *
 *Created by yuchenghao on 2024/10/7 23:07.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理已知异常
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Result<?> handle(ApiException e){
      if(e.getResult() == null) return  Result.failed(e.getMessage());
      return Result.failed(e.getResult());
    }
    /**
     * 处理未知异常
     */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Result<?> handleRuntimeException(RuntimeException e) {
        //log.error("run time error --------> [{}] ", Arrays.toString(e.getStackTrace()));
        return Result.failed(EResult.SYSTEM_ERROR);
    }


    /**
     * 验证jsr303失败的异常
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getDefaultMessage();
            }
        }
        return Result.validateFailed(message);
    }

    /**
     * 数据绑定异常
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Result<?> handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return Result.validateFailed(message);
    }

}
