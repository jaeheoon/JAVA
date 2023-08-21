package com.ezen.springmvc.domain.common.web.service;

import java.util.List;

import com.ezen.springmvc.domain.article.dto.Article;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * @author 홍재헌
 */
public interface PageService {
	/** 게시판 전체 갯수 출력 */
	public int findAllCount();
	
	/** 검색된 게시판 게시글 출력 */
	public List<Article> findSearchPage();

	/** 계층형 게시판 및 페이징 처리를 위한 게시글목록 조회 */
	public List<Article> findSearchArticle();
	
}
