package com.ezen.mybatis.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {
	private int id;				//게시글 id
	private int boardId;		//게시판 id
	private String writer;		//게시글 작성자
	private String subject;		//게시글 제목
	private String content;		//게시글 내용
	private String regdate;		//게시글 등록일자
	private int hitcount;		//페이지 조회수
	private String passwd;		//게시글 비밀번호
	private int groupNo;		//계층형 게시판 구조를 위한 게시글 그룹번호
	private int levelNo;		//계층형 게시판 구조를 위한 그룹 내 게시글 레벨
	private int orderNo;		//계층형 게시판 구조를 위한 그룹 내 게시글 순서
}
