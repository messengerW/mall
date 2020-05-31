package com.mall.coupon.dao;

import com.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author msw
 * @email 347888930@qq.com
 * @date 2020-05-31 17:30:39
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
