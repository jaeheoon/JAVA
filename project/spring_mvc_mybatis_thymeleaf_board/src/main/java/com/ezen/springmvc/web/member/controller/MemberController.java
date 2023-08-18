package com.ezen.springmvc.web.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * MemberService 화면 컨트롤러
 * @author 홍재헌
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("")
	public String list(Model model) {
		log.info("회원 목록 요청 ");
		List<Member> list = memberService.getMemberList();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@GetMapping("/{id}")
	public String read(@PathVariable("id") String id, Model model) {
		log.info("회원 상세 정보 요청");
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);
		return "member/read";
	}
}
