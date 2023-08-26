package com.ezen.springmvc.web.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.article.service.ArticleService;
import com.ezen.springmvc.domain.common.web.dto.PageParams;
import com.ezen.springmvc.domain.common.web.dto.Pagination;
import com.ezen.springmvc.domain.common.web.service.PageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * BoardService 화면 컨트롤러
 * @author 홍재헌
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

	private final ArticleService articleService;
	private final PageService pageService;
	
//	보여지는 글 갯수(게시판 제목)
	private final int ELEMENT_SIZE = 10;
	
//	목록 갯수(1, 2, 3, 4, 5)
	private final int PAGE_SIZE = 5;
	
	@GetMapping("/{boardId}")
	public String listForm(@PathVariable("boardId") int boardId, @RequestParam(defaultValue = "1") int requestPage, Model model) {
		
		int rowCount = pageService.pageCount(boardId);
		
		PageParams pageParams = PageParams.builder()
											.pageSize(PAGE_SIZE)
											.elementSize(ELEMENT_SIZE)
											.requestPage(requestPage)
											.rowCount(rowCount)
											.build();
		
		Pagination pagination = new Pagination(pageParams);
		
		List<Article> list = pageService.pageList(pageParams, boardId);
		
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardId", boardId);
		
		return "board/list";
	}
	
	@PostMapping("/{boardId}")
	public String list(@PathVariable("boardId") int boardId, @RequestParam(defaultValue = "1") int requestPage, @RequestParam("type") String type, @RequestParam("value") String value, Model model) {
		log.info("게시판 목록 요청 {}, {} ", type, value);
		
		int rowCount = pageService.pageCount(boardId);
		
		PageParams pageParams = PageParams.builder()
											.pageSize(PAGE_SIZE)
											.elementSize(ELEMENT_SIZE)
											.requestPage(requestPage)
											.rowCount(rowCount)
											.build();
		
		Pagination pagination = new Pagination(pageParams);
		
		List<Article> list = pageService.pageList(pageParams, boardId);
		
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardId", boardId);
		return "board/list";
	}
	
	@GetMapping("/read/{boardId}")
	public String read(@RequestParam("articleId") int articleId, @PathVariable("boardId") int boardId, Model model) {
//		log.info("게시글 상세 정보 요청");
		Article article = articleService.readArticle(boardId, articleId);
		model.addAttribute("article", article);
		return "board/read";
	}
}
