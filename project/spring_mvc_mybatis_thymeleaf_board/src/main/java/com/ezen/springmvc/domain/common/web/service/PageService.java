package com.ezen.springmvc.domain.common.web.service;

import java.util.List;

import com.ezen.springmvc.domain.article.dto.Article;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * @author 홍재헌
 */
public interface PageService {
	/** 검색된 게시판 갯수 */
	public int pageCount();
	
	/** 검색된 게시판 게시글 목록 출력 */
	public List<Article> pageList(int rows, int boardId, int page);
	
}
