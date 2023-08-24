package com.ezen.springmvc;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.member.dao.MemberDao;
import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SpringAOPTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
//	@Disabled
	public void getMemberTest() {
		Member member = memberService.getMember("monday");
		log.info("회원 정보 : {}", member);
	}
	
}
