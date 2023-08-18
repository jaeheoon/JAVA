package com.ezen.springmvc.web.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.domain.board.dto.Board;
import com.ezen.springmvc.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * BoardService 화면 컨트롤러
 * @author 홍재헌
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("")
	public String list(Model model) {
		log.info("회원 목록 요청 ");
		List<Board> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		log.info("게시판 상세 정보 요청");
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		return "board/read";
	}
}
