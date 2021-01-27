package com.mall.search.service;

import com.mall.search.vo.SearchParam;
import com.mall.search.vo.SearchResult;

/**
 * <p>Title: MallSearchService</p>
 * Description：
 * date：2020/6/12 23:05
 */
public interface MallSearchService {

	/**
	 * 检索所有参数
	 */
	SearchResult search(SearchParam Param);
}
