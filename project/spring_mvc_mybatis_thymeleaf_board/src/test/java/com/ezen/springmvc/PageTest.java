package com.ezen.springmvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.common.web.mapper.PaginationMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PageTest {

	@Autowired
	private PaginationMapper paginationMapper;

	@Test
	@Disabled
	@DisplayName("전체 게시판 갯수")
	void findAllCountTest() {
		log.info("==================== 전체 게시판 조회 ========================");
		int count = paginationMapper.findAllCount();
		log.info("전체 게시판 갯수는 : {}", count);
	}
	
	@Test
	@Disabled
	@DisplayName("검색 게시판 갯수")
	void findSearchCountTest(String type, String searchPage) {
		log.info("==================== 검색 게시판 조회 ========================");
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
//		searchParams.put("type", type);
//		searchParams.put("boardId", Integer.valueOf(searchPage));
		
		searchParams.put("type", type);
		searchParams.put("value", searchPage);
		int count = paginationMapper.findSearchCount(searchParams);
		log.info("검색 게시판 갯수는 : {}", count);
	}
	
	@Test
	@DisplayName("검색된 페이지 정보")
	@Disabled
	void findSearchPageTest(String type, String searchPage) {
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
//		searchParams.put("type", type);
//		searchParams.put("value", Integer.valueOf(searchPage));

		searchParams.put("type", type);
		searchParams.put("value", searchPage);
		
		List<Article> pages = paginationMapper.findSearchPage(searchParams);
		for (Article article : pages) {
			log.info("검색된 페이지 정보 : {}", article);
		}
	}
	
	@Test
	@DisplayName("계층형 게시판 및 페이징 처리를 위한 게시글 목록")
	@Disabled
	void findSearchArticleTest(int rows, int boardId) {
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		
		searchParams.put("rows", rows);
		searchParams.put("boardId", boardId);
		
		List<Article> pages = paginationMapper.findSearchArticle(searchParams);
		for (Article article : pages) {
			log.info("검색된 계층형 페이지 정보 : {}", article);
		}
	}
	
	@Test
	@Disabled
	@DisplayName("페이징 처리 테스트")
	void paginationTest() {
		findSearchArticleTest(5, 20);
	}
}
