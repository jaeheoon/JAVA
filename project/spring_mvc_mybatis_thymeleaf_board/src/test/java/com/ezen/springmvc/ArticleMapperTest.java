package com.ezen.springmvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.article.dto.Article;
import com.ezen.springmvc.domain.article.mapper.ArticleMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ArticleMapperTest {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Test
	@Disabled
	@DisplayName("전체 게시글 목록 반환")
	public void findAllTest() {
		List<Article> list = articleMapper.findAll();
		for (Article article : list) {
			log.info(article.toString());
		}
	};
	
	@Test
	@Disabled
	@DisplayName("id로 게시글 상세정보 찾기")
	public void readArticleTest() {
		Article article = articleMapper.readArticle(1);
		log.info(article.toString());
	};
	
	
	@Test
	@Disabled
	@DisplayName("게시글 등록 테스트")
	public void registerTest() {
		Article article = Article.builder()
							.boardId(30)
							.writer("monday")
							.subject("테스트 1234")
							.content("테스트 내용 1234")
							.passwd("1111")
							.levelNo(0)
							.orderNo(0)
							.build();
		articleMapper.create(article);
	}
	
	@Test
	@Disabled
	@DisplayName("댓글 등록 테스트")
	public void commentCreateTest() {
		Article article = Article.builder()
				.boardId(20)
				.writer("monday")
				.subject("테스트 댓글 1234")
				.content("테스트 댓글 내용 1234")
				.passwd("1111")
				.groupNo(74)
				.levelNo(1)
				.orderNo(1)
				.build();
		articleMapper.commentCreate(article);
		assertThat(article).isNotNull();
	}
	
	@Test
	@Disabled
	@DisplayName("게시글 삭제 테스트")
	public void deleteArticleTest() {
		articleMapper.deleteArticle(133, "1111");
	}
	
	
}
