
package com.ezen.springmvc.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * 회원관련 요청(CRUD) 요청에 대한 세부 컨트롤러(핸들러)
 * @author 홍재헌
 */
@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
	
//	model은 서버에서 받은 데이터를 화면에 출력해주기 위해 세팅, 필요없으면 add 안해도 됨
	@GetMapping({"/regist"})
	public String form(Model model) {
		return "regist";
	}
	
//	@PostMapping("/regist")
//	public String regist(@RequestParam String id,@RequestParam String passwd, Model model) {
////		service를 이용한 DB 등록 처리
//		log.info("수신한 아이디 : {}", id);
//		log.info("수신한 비밀번호 : {}", passwd);
//		return "redirect:regist-result";
//	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Member member, Model model) {
//		service를 이용한 DB 등록 처리
		log.info("수신한 사용자 정보 : {}", member);
		log.info("수신한 사용자 아이디 : {}", member.getId());
		log.info("수신한 사용자 나이 : {}", member.getAge() + 5);
		return "redirect:regist-result";
	}
	
	@GetMapping("/regist-result")
	public String registResult(Model model) {
//		service를 이용한 DB 등록 처리
//		앞에 redirect를 안써주면 return은 포워드가 돼서 2중등록됨 그래서 리다이렉트를 사용해야함
		return "regist-result";
	}
	
//	파라메터를 받을때 어떤 특정한 값이 일치할때만 처리하게끔 하고싶을때
	@GetMapping(value = "/find", params = "admin=bangry")
	public String find(Model model) {
		return "hello";
	}
	
//	회원 상세정보 받아오기
//	member/bangry
	@GetMapping(value = "/{memberId}")
	public String read(Model model, @PathVariable String memberId, @CookieValue(value = "loginId", required = false, defaultValue = "bangry") String loginId) {
		log.info("아이디 : {}", memberId);
		log.info("로그인 아이디 : {}", loginId);
		return "hello";
	}
	
//	회원 상세정보 받아오기
//	member/bangry
	@PostMapping(value = "/login")
	public String login(@RequestParam String id, @RequestParam String passwd, HttpSession session, Model model) {
//		DB에서 가져온 로그인 정보를 session에 받아옴
		session.setAttribute("loginId", id);
		log.info("세션에 저장된 아이디 : {}", session.getAttribute("loginId"));
		return "hello";
	}
}
