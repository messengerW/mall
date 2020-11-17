package com.mall.product.exception;
/*
 * File: ExceptionControllerAdvice.java
 * Date: 2020-11-17 20:55
 * Author: msw
 * PS ...
 */

import com.mall.common.exception.BusinessCodeEnum;
import com.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.mall.product.controller")
public class ExceptionControllerAdvice {
    /**
     * 异常统一拦截处理
     * 前面的方法为个性化拦截处理，最后一个兜底
    */

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());

        Map<String, String> errorMap = new HashMap<>();
        BindingResult result = e.getBindingResult();

        result.getFieldErrors().forEach((error)->{
            String field = error.getField();             // 出现异常的字段
            String message = error.getDefaultMessage();  // 异常信息
            errorMap.put(field, message);
        });
        return R.error(BusinessCodeEnum.VALID_EXCEPTION.getCode(), BusinessCodeEnum.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    /**
     * 拦截所有异常（Throwable）
    */
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {

        return R.error(BusinessCodeEnum.UNKNOWN_EXCEPTION.getCode(), BusinessCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
