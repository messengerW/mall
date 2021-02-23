package com.mall.common.exception;
/*
 * File: NoStockException.java
 * Date: 2020-11-26 21:35
 * Author: msw
 * PS ...
 */


import lombok.Getter;
import lombok.Setter;

public class NoStockException extends RuntimeException{

    @Setter @Getter
    private Long skuId;

    public NoStockException(String msg) {
        super(msg + "号商品没有足够的库存了");
    }
}