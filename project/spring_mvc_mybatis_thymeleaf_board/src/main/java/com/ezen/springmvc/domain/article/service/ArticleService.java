package com.ezen.springmvc.domain.article.service;

import java.util.List;

import com.ezen.springmvc.domain.article.dto.Article;

/**
 * 게시글 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * @author 홍재헌
 */
public interface ArticleService {
	
	public void register(Article article);
	public List<Article> getArticleList();
	public Article getArticle(int id);
	
}
