package com.mall.order.to;
/*
 * File: OrderCreateTo.java
 * Date: 2021-02-23 21:57
 * Author: msw
 * PS ...
 */

import com.mall.order.entity.OrderEntity;
import com.mall.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderCreateTo {

    private OrderEntity order;

    private List<OrderItemEntity> orderItems;

    /**
     * 订单计算的应付价格
     */
    private BigDecimal payPrice;

    /**
     * 运费
     */
    private BigDecimal fare;
}