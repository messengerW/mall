package com.mall.member.dao;

import com.mall.member.entity.MemberLevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员等级
 * 
 * @author msw
 * @email 347888930@qq.com
 * @date 2020-05-31 20:50:09
 */
@Mapper
public interface MemberLevelDao extends BaseMapper<MemberLevelEntity> {

	MemberLevelEntity getDefaultLevel();
}
