package com.ezen.springmvc.domain.common.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.common.web.dto.PageParams;
import com.ezen.springmvc.domain.common.web.mapper.PaginationMapper;

import lombok.RequiredArgsConstructor;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
@RequiredArgsConstructor
@Service
public class PageServiceImpl implements PageService {
	
	private final PaginationMapper paginationMapper;

//	검색된 게시판 게시글 목록 출력
	@Override
	public List<Article> pageList(PageParams pageParams, int boardId) {
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		
		searchParams.put("rows", pageParams.getElementSize());
		searchParams.put("boardId", boardId);
		searchParams.put("requestPage", pageParams.getRequestPage());
		
		List<Article> pages = paginationMapper.findArticleSearch(searchParams);
		
		return pages;
	}

	@Override
	public int pageCount(int boardId) {
		return paginationMapper.findArticleCount(boardId);
	}

	@Override
	public List<Article> pageSearchList(PageParams pageParams, String searchType, String searchValue, int boardId) {
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		
		searchParams.put("rows", pageParams.getElementSize());
		searchParams.put("boardId", boardId);
		searchParams.put("requestPage", pageParams.getRequestPage());
		
		List<Article> pages = paginationMapper.findSearchPage(searchParams);
		
		return pages;
	}
	
	@Override
	public int pageSearchCount(String searchType, String searchValue, int boardId) {
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		
		searchParams.put("type", searchType);
		searchParams.put("value", searchValue);
		searchParams.put("boardId", boardId);
		
		return paginationMapper.findSearchCount(searchParams);
	}
	

}
