package com.ezen.springmvc.domain.common.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.springmvc.domain.article.dto.Article;
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
	
	@Override
	public int findAllCount() {
		return paginationMapper.findAllCount();
	}

	@Override
	public List<Article> findSearchPage() {
		return null;
	}

	@Override
	public List<Article> findSearchArticle() {
		return null;
	}

	
	
}
