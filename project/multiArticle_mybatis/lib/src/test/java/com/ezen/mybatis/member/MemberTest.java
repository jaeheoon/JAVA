package com.ezen.mybatis.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ezen.mybatis.domain.member.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberTest {

	private static final String namespace = "com.ezen.mybatis.domain.member.mapper.MemberMapper";
	private SqlSession sqlSession = null;

	@BeforeEach
	void init() {
		String resource = "mybatis-config2.xml";

		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sqlSessionFactory.openSession(true);

		System.out.println("==================== sqlSession 생성 완료 ====================");
	}

	@Test
	@Disabled
	void findByAllTest() {
		List<Member> memeberList = sqlSession.selectList(namespace + ".findByAll");
		log.debug("=====사원 전체 목록=====");
		for (Member member : memeberList) {
			log.debug("{}", member);
		}

		assertThat(memeberList)
			.isNotNull();
	}

	@Test
	@Disabled
	void findByIdTest() {
		// given
		String memberId = "bangry";
		// when
		Member member = sqlSession.selectOne(namespace + ".findById", memberId);
		// then
		log.debug("검색된 사원 정보 : {}", member);
		assertThat(member)
			.isNotNull();
	}
	
	@Test
//	@Disabled
	void findByUserTest() {
		Map<String, String> params = new HashMap<>();
		params.put("id", "bangry3");
		params.put("passwd", "1111");
		Member member = sqlSession.selectOne(namespace + ".findByUser", params);
		log.debug("검색된 사원 정보 : {}", member);
		assertThat(member)
		.isNotNull();
	}
	
	@Test
	@Disabled
	void createTest() {
		Member member = Member.builder()
							.id("bangry4")
							.passwd("1111")
							.name("유재헌")
							.email("bangry4@gmail.com")
							.build();
		sqlSession.insert(namespace + ".create", member);
		sqlSession.commit();
//		sqlSession.rollback();
		System.out.println("신규사원 등록 완료");
		assertThat(member)
		.isNotNull();
	}
	
	
}
