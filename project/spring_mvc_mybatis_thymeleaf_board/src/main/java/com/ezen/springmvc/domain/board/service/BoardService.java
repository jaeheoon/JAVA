package com.ezen.springmvc.domain.board.service;

import java.util.List;

import com.ezen.springmvc.domain.board.dto.Board;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리
 * @author 홍재헌
 */
public interface BoardService {
	
	public void register(Board board);
	public List<Board> getBoardList();
	public Board getBoard(int id);
	
}
