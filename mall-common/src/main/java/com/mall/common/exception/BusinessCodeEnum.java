package com.mall.common.exception;
/**
 * <br>错误码和错误信息定义类
 * <br>1. 错误码定义规则为5位数字
 * <br>2. 前两位表示业务场景，最后三位表示错误码。例如：100001。10:通用 001:系统未知异常
 * <br>3. 维护错误码后需要维护错误描述，将他们定义为枚举形式
 * <br>错误码列表：
 * <br>10: 通用
 *    <br>001：参数格式校验
 *    <br>002：短信验证码频率太高
 *  <br>11: 商品
 *  <br>12: 订单
 *  <br>13: 购物车
 *  <br>14: 物流
 *  <br>15: 用户
 *  <br>21: 库存
 * @author x3626
 */

public enum BusinessCodeEnum {
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败"),
    SMS_CODE_EXCEPTION(10002, "验证码获取频率太高,稍后再试"),
    TO_MANY_REQUEST(10003, "请求流量过大"),
    SMS_SEND_CODE_EXCEPTION(10403, "短信发送失败"),
    USER_EXIST_EXCEPTION(15001, "用户已经存在"),
    PHONE_EXIST_EXCEPTION(15002, "手机号已经存在"),
    LOGINACTT_PASSWORD_ERROR(15003, "账号或密码错误"),
    SOCIALUSER_LOGIN_ERROR(15004, "社交账号登录失败"),
    NOT_STOCK_EXCEPTION(21000, "商品库存不足"),
    PRODUCT_UP_EXCEPTION(11000,"商品上架异常");

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