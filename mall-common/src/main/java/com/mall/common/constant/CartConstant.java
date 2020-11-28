package com.mall.common.constant;
/*
 * File: CartConstant.java
 * Date: 2020-11-26 21:27
 * Author: msw
 * PS ...
 */


public class CartConstant {
    /**
     * 临时用户的cookie名称
     */
    public static final String TEMP_USER_COOKIE_NAME = "user-key";
    /**
     * 临时用户cookie的过期时间
     */
    public static final int TEMP_USER_COOKIE_TIMEOUT = 60 * 60 * 24 * 30;
    /**
     * 购物车保存进redis数据的前缀
     */
    public static final String CART_PREFIX = "mall:cart:";
}
