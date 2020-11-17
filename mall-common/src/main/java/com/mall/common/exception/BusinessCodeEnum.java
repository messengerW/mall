package com.mall.common.exception;
/*
 * File: BusinessCodeEnum.java
 * Date: 2020-11-17 21:19
 * Author: msw
 * PS ...
 */


public enum BusinessCodeEnum {
    /*
     * 【错误码&错误信息定义类】
     * 1.错误码由 5位数字 构成
     * 2.前两位表示表示业务场景，后三位表示错误信息
     *   10××× : 公共服务 common
     *   11××× : 商品服务 product
     *   12××× : 订单服务 order
     *   13××× : 购物车服务 car
     *   14××× : 物流服务 express
    */

    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败");

    private final int code;
    private final String msg;

    BusinessCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
