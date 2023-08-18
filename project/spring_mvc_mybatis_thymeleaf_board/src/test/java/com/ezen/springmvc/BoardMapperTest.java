package com.ezen.springmvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.board.dto.Board;
import com.ezen.springmvc.domain.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	@Disabled
	public void findAllTest() {
		List<Board> list = boardMapper.findAll();
		for (Board board : list) {
			log.info(board.toString());
		}
	};
	
	@Test
//	@Disabled
	public void findByIdTest() {
		Board board = boardMapper.findById(70);
		log.info("검색된 게시판 정보 : {}", board);
	};
	
	@Test
	@Disabled
	void updateTest() {
		Board updateBoard = new Board();
		updateBoard.setId(50);
		updateBoard.setTitle("게시판 제목 테스트123");
		updateBoard.setDescription("게시판 내용 테스트123");
		boardMapper.update(updateBoard);
		log.debug("{}", updateBoard);
		
		assertThat(updateBoard)
			.isNotNull();
	}
	
	@Test
	@Disabled
	void createTest() {
		Board board = Board.builder()
							.category(3)
							.title("게시판 제목 테스트")
							.description("게시판 내용 테스트")
							.build();
		boardMapper.create(board);
		log.info("신규 게시판 등록 완료 : {}", board);
		assertThat(board)
			.isNotNull();
	}
	
}
