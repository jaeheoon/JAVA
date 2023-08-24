package com.ezen.springmvc.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ezen.springmvc.domain.member.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("")
	//public String home(HttpServletRequest request, Model model) {
	public String home(@SessionAttribute(name="loginMember", required = false) Member loginMember, Model model) {
		log.info("home request");
		//HttpSession session = request.getSession(false);
		if (loginMember != null) {
			//Member loginMember = (Member)session.getAttribute("loginMember");
			model.addAttribute("member", loginMember);
		}
		
		return "index";
	}
}
