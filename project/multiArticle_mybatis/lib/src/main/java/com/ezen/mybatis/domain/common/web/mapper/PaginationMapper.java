package com.ezen.mybatis.domain.common.web.mapper;

import java.util.Map;

public interface PaginationMapper {
	/** 게시판 전체 갯수 출력 */
	public int findAllCount();
	
	/** 검색된 게시판 갯수 출력 */
	public int findSearchCount(Map<String, Object> searchArticle);

}
