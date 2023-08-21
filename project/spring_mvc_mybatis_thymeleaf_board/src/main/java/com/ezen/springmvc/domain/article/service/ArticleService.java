package com.ezen.springmvc.domain.article.service;

import java.util.List;

import com.ezen.springmvc.domain.article.dto.Article;

/**
 * 게시글 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * @author 홍재헌
 */
public interface ArticleService {
	
	/** 게시글 등록*/
	public void register(Article article);
	
	/** 게시글 댓글 등록 */
	public void commentCreate(Article article);
	
	/** 게시글 대댓글 등록 */
	public void setRRefly(Article article);
	
	/** 게시글 삭제*/
	public void deleteArticle(int articleId, String passwd);
	
	/** 게시글 수정*/
	public void updateArticle(Article article);
	
	/** 게시글 상세 정보 출력*/
	public Article readArticle(int boardId, int articleId);
	
	/** 해당 게시판 게시글 리스트 출력 */
	public List<Article> readAllArticle(int boardId);
	
}
