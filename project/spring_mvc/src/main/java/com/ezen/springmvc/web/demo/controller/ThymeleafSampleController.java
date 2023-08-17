package com.ezen.springmvc.web.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/thymeleaf")
@Slf4j
public class ThymeleafSampleController {
	
	@GetMapping("/exam1")
	public String exam1(Model model) {
		
//		DB에서 가져온 데이터라 가정
		Member2 member = Member2.builder()
				.id("bangry")
				.passwd("1111")
				.age(26)
				.build();
		
		List<Member2> list = new ArrayList<Member2>();
		list.add(new Member2("hong1", "1111", 27));
		list.add(new Member2("hong2", "1111", 28));
		list.add(new Member2("hong3", "1111", 29));
		
		model.addAttribute("member", member);
		model.addAttribute("members", list);
		return "demo/exam1";
	}
	
	@GetMapping("/exam2")
	public String exam2(Model model) {
		model.addAttribute("score", 88);
		return "demo/exam2";
	}
	
	@GetMapping("/exam3")
	public String exam3(Model model) {
		model.addAttribute("id", "bangry");
		model.addAttribute("name", "홍재헌");
		return "demo/exam3";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Member2 member, Model model, RedirectAttributes redirectAttributes) {
		log.info("수신한 회원 정보 : {}", member);
//		회원 가입 후 결과 페이지로 재요청(redirect를 안하면 이중등록됨
		redirectAttributes.addFlashAttribute("result", "success");
		redirectAttributes.addFlashAttribute("member", member);
		
		return "redirect:/thymeleaf/member-result";
	}
	
//	redirect된 페이지를 받고 결과 페이지로 이동시켜주는 역할
	@GetMapping("/member-result")
	public String registResult(Model model) {
		return "demo/member-result";
	}
	
//	redirect된 페이지를 받고 결과 페이지로 이동시켜주는 역할
	@GetMapping("/regist")
	public String form(Model model) {
		return "demo/regist-form";
	}
	

}
