package com.ezen.springmvc.domain.common.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.springmvc.domain.article.dto.Article;

@Mapper
public interface PaginationMapper {
	/** 검색된 게시판 갯수 출력 */
	public int findSearchCount(Map<String, Object> searchArticle);
	
	/** 검색된 게시판 게시글 출력 */
	public List<Article> findSearchPage(Map<String, Object> searchArticle);

	/** 계층형 게시판 및 페이징 처리를 위한 게시글목록 조회 */
	public List<Article> findSearchArticle(Map<String, Object> searchArticle);
}
