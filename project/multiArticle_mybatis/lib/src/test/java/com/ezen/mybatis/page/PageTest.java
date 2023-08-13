package com.ezen.mybatis.page;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.common.web.mapper.PaginationMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PageTest {

	private SqlSession sqlSession = null;

	@BeforeEach
	void init() {
		String resource = "mybatis-config.xml";

		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession(true);

		log.info("==================== sqlSession 생성 완료 ====================");
	}

	@Test
	@Disabled
	@DisplayName("전체 게시판 갯수")
	void findAllCountTest() {
		log.debug("==================== 전체 게시판 조회 ========================");
		PaginationMapper mapper = sqlSession.getMapper(PaginationMapper.class);
		int count = mapper.findAllCount();
		log.debug("전체 게시판 갯수는 : {}", count);
	}
	
	@Test
//	@Disabled
	@DisplayName("검색 게시판 갯수")
	void findSearchCountTest() {
		log.debug("==================== 검색 게시판 조회 ========================");
		PaginationMapper mapper = sqlSession.getMapper(PaginationMapper.class);
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
//		searchParams.put("type", "id");
//		searchParams.put("boardId", 10);
		
		searchParams.put("type", "name");
		searchParams.put("value", "monday");
		int count = mapper.findSearchCount(searchParams);
		log.debug("검색 게시판 갯수는 : {}", count);
	}

	@AfterEach
	public void destory() {
		sqlSession.close();
	}

}
