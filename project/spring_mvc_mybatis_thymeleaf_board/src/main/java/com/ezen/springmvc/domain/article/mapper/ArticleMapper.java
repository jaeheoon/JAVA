package com.ezen.springmvc.domain.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.common.web.dto.PageParams;

/**
 * article 테이블 관련 명세
 */
@Mapper
public interface ArticleMapper {
	/** 신규 게시글 등록 */
	public void create(Article article);
	
	/** 전체 게시글 목록 반환 - 필요없지만 연습용 */
	public List<Article> findAll();
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환 - 전체 글 갯수 - 필요없지만 연습용
	public int getCount();
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환 - 검색된 값(이름 or 제목 or 내용) 갯수
	public int getCountAll(PageParams pageParams);
	
	// 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환
	public List<Article> findByAll(PageParams pageParams);
	
	// 댓글, 대댓글 쓰기, 게시글 상세보기, 게시글 수정, 게시글 삭제 기능 추가하기--------------------------
	
	// 댓글 쓰기 기능
	public void commentCreate(Article article);
	
	//대댓글 적기 전 선택된게시판 id와 해당하는 글의 id를 받아와 order_no 증가
	public boolean updateOrderNo(@Param("articleId") int articleId, @Param("boardId") int boardId);
	
	// 대댓글 쓰기 기능
	public boolean setRRefly(Article article);
	
	//해당 그룹 모든 글
	public List<Article> readGroupArticle(int groupNo);
	
	//id로 게시글 상세정보 찾기
	public Article readArticle(int articleId);
	
	// Article id 받아서 삭제
	public boolean deleteArticle(@Param("articleId") int articleId, @Param("passwd") String passwd);
	
	// 댓글 수정 기능
	public void updateArticle(Article article);
}
