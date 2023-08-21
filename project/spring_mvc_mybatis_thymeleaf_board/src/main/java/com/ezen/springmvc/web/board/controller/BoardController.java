package com.ezen.springmvc.web.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.article.service.ArticleService;

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
	
	@GetMapping("")
	public String list(@RequestParam("boardId") int boardId, Model model) {
//		log.info("게시판 목록 요청 ");
		List<Article> list = articleService.readAllArticle(boardId);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("/{articleId}")
	public String read(@PathVariable("articleId") int articleId, @RequestParam("boardId") int boardId,  Model model) {
//		log.info("게시글 상세 정보 요청");
		Article article = articleService.readArticle(boardId, articleId);
		model.addAttribute("article", article);
		return "board/read";
	}
}
