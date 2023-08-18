package com.ezen.springmvc.web.article.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.article.service.ArticleService;
import com.ezen.springmvc.domain.board.dto.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ArticleService 화면 컨트롤러
 * @author 홍재헌
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
@Slf4j
public class ArticleController {

	private final ArticleService articleService;
	
	@GetMapping("")
	public String list(Model model) {
		log.info("게시판 목록 요청 ");
		List<Article> list = articleService.getArticleList();
		model.addAttribute("list", list);
		return "article/list";
	}
	
	@GetMapping("/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		log.info("게시판 상세 정보 요청");
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		return "article/read";
	}
}
