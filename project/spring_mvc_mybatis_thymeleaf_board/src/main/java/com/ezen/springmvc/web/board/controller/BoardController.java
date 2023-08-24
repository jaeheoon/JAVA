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
	
	private final int ELEMENT_SIZE = 10;
	private final int PAGE_SIZE = 10;
	
	@GetMapping("/{boardId}")
	public String listForm(@PathVariable("boardId") int boardId, Model model) {
		List<Article> list = articleService.readAllArticle(boardId);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@PostMapping("/{boardId}")
	public String list(@PathVariable("boardId") int boardId, @RequestParam("type") String type, @RequestParam("value") String value, Model model) {
		log.info("게시판 목록 요청 {}, {} ", type, value);
		List<Article> list = articleService.readAllArticle(boardId);
		model.addAttribute("list", list);
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
