package com.ezen.springmvc;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.common.web.dto.PageParams;
import com.ezen.springmvc.domain.common.web.service.PageService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PageServiceTest {

	@Autowired
	private PageService pageService;

	@Test
	@DisplayName("계층형 게시판 및 페이징 처리를 위한 게시글 목록")
//	@Disabled
	void findSearchArticleTest() {
//		게시글을 몇개씩 볼건지
		int size = 5;
		
//		게시글 목록을 몇개씩 볼건지
		int element = 10;
		
//		선택한 게시글 목록 번호
		int page = 1;
		
//		검색된 게시글 갯수
		int rows = 69;
		
//		어디 게시판에서 볼건지
		int boardId = 10;
		
		PageParams pageParams = PageParams.builder()
									.pageSize(size)
									.rowCount(rows)
									.requestPage(page)
									.elementSize(element)
									.build();
		
		List<Article> pages = pageService.pageList(pageParams, boardId);
		for (Article article : pages) {
			log.info("검색된 계층형 페이지 정보 : {}", article);
		}
	}
}
