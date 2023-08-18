package com.ezen.springmvc.domain.article.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.article.mapper.ArticleMapper;

import lombok.RequiredArgsConstructor;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {
	
	private final ArticleMapper articleMapper;

	//트랜잭션을 필요한 곳에만 선언해주는 것이 좋다
	@Override
	@Transactional
	public void register(Article article) {
		articleMapper.create(article);
	}

	@Override
	public List<Article> getArticleList() {
		return articleMapper.findAll();
	}

	@Override
	public Article getArticle(int id) {
		return null;
	}

}
