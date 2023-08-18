package com.ezen.springmvc.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.springmvc.domain.board.dto.Board;

/**
 * board 테이블 관련 명세
 */
@Mapper
public interface BoardMapper {
	/** 신규 게시판 생성 */
	public void create(Board board);
	
	/** 전체 게시판 목록 반환 */
	public List<Board> findAll();
	
	/** 검색 게시판 정보 반환 */
	public Board findById(int id);
	
	/** 게시판 수정 */
	public void update(Board updateBoard);
	
}
