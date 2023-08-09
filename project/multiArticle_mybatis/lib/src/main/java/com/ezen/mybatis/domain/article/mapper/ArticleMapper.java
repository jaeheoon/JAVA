package com.ezen.mybatis.domain.article.mapper;

import java.util.List;

import com.ezen.mybatis.domain.article.dto.ArticleDTO;
import com.ezen.mybatis.domain.common.web.PageParams;

/**
 * article 테이블 관련 명세
 */
public interface ArticleMapper {
	/** 신규 게시글 등록 */
	public void create(ArticleDTO articleDTO);
	
	/** 전체 게시글 목록 반환 - 필요없지만 연습용 */
	public List<ArticleDTO> findAll();
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환 - 전체 글 갯수 - 필요없지만 연습용
	public int getCount();
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환 - 검색된 값(이름 or 제목 or 내용) 갯수
	public int getCountAll(PageParams pageParams);
	
	// 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환
	public List<ArticleDTO> findByAll(PageParams pageParams);
	
	// 댓글, 대댓글 쓰기, 게시글 상세보기, 게시글 수정, 게시글 삭제 기능 추가하기
	
	// 댓글 쓰기 기능
	public void commentCreate(ArticleDTO articleDTO);
	
	// 대댓글 쓰기 기능
	public void setRRefly(ArticleDTO articleDTO);
	
	// Article id 받아서 삭제
	public boolean deleteArticle(int articleId, String passwd);
}
