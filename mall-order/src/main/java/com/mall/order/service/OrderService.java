package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 订单
 *
 * @author msw
 * @email 347888930@qq.com
 * @date 2020-05-31 21:11:26
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageWithItem(@Param("params") Map<String, Object> params);

    OrderEntity getOrderByOrderSn(String orderSn);
}

