package com.mall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: Catelog2Vo</p>
 * Description：
 * date：2020/6/9 14:41
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catalog2Vo implements Serializable {

	/**
	 * 1级父分类的id
	 */
	private String catalog1Id;
	/**
	 * 三级子分类
	 */
	private List<Catalog3Vo> catalog3List;
	/**
	 * 2级分类的id
	 */
	private String id;
	/**
	 * 2级分类名称
	 */
	private String name;

	/**
	 * 3级分类的Vo
	 */
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Catalog3Vo{
		/**
		 * 2级父分类的id
		 */
		private String catalog2Id;
		/**
		 * 3级分类id
		 */
		private String id;
		/**
		 * 3级分类名称
		 */
		private String name;
	}
}
