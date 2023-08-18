package com.ezen.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.board.dto.Board;
import com.ezen.springmvc.domain.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService boardService;
	
	@Test
//	@Disabled
	public void isBoardAllTest() {
		List<Board> list = boardService.getBoardList();
		log.info("게시판 정보 : {}", list);
	}
}
