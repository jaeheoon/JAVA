package com.ezen.springmvc.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 회원 관련 API 서비스 세부 컨트롤러
 * @author 홍재헌
 */
@Controller
@Slf4j
@RequestMapping("/member2")
public class RestMemberController {
	
//	회원 상세정보 받아오기
//	member/bangry
	@GetMapping(value = "/{memberId}")
	@ResponseBody
	public String read(Model model, @PathVariable String memberId, @RequestBody(required = false) String text) {
		String id = "bangry";
		String name = "홍재헌";
		log.info("수신한 텍스트: {}", text);
		return "아이디: "+ id+", 이름: " + name;
	}
}

