package com.ezen.springmvc.web.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/thymeleaf")
@Slf4j
public class ThymeleafSampleController {
	
	@GetMapping("/exam1")
	public String exam1(Model model) {
		
//		DB에서 가져온 데이터라 가정
		Member member = Member.builder()
				.id("bangry")
				.passwd("1111")
				.age(26)
				.build();
		
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("hong1", "1111", 27));
		list.add(new Member("hong2", "1111", 28));
		list.add(new Member("hong3", "1111", 29));
		
		model.addAttribute("member", member);
		model.addAttribute("members", list);
		return "demo/exam1";
	}
	
}
