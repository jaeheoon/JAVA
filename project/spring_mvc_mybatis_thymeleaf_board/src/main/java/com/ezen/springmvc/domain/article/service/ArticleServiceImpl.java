package com.ezen.springmvc.domain.article.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.article.mapper.ArticleMapper;

import lombok.RequiredArgsConstructor;

/**
 * 게시글 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
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
	@Transactional
	public void deleteArticle(int articleId, String passwd) {
		articleMapper.deleteArticle(articleId, passwd);
	}

	@Override
	@Transactional
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article);
	}

	@Override
	@Transactional
	public void commentCreate(Article article) {
		articleMapper.commentCreate(article);
	}

	@Override
	@Transactional
	public void setRRefly(Article article) {
		articleMapper.updateOrderNo(article.getArticleId(), article.getBoardId());
		articleMapper.setRRefly(article);
	}

	@Override
	public Article readArticle(int articleId) {
		return articleMapper.readArticle(articleId);
	}

}
