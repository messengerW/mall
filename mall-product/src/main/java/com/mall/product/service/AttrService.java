package com.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.product.entity.AttrEntity;
import com.mall.product.vo.AttrVO;

import java.util.Map;

/**
 * 商品属性
 *
 * @author msw
 * @email 347888930@qq.com
 * @date 2020-05-31 15:01:29
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVO attr);
}

