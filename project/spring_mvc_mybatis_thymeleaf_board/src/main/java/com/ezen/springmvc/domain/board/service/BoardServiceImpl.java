package com.ezen.springmvc.domain.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.board.dto.Board;
import com.ezen.springmvc.domain.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;

	//트랜잭션을 필요한 곳에만 선언해주는 것이 좋다
	@Override
	@Transactional
	public void register(Board board) {
		boardMapper.create(board);
	}

	@Override
	public List<Board> getBoardList() {
		return boardMapper.findAll();
	}

	@Override
	public Board getBoard(int id) {
		return boardMapper.findById(id);
	}

}
