package com.ezen.springmvc.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * /hello 요청에 대한 세부 컨트롤러(핸들러)
 * @author 홍재헌
 */
@Controller
public class HelloController {
	
//	@GetMapping("/hello")
//	@GetMapping("/some/hello")
//	@GetMapping("/some/*")
	@GetMapping({"/hello", "/hi"})
	public String hello(Model model) {
		String message = "서버로부터 받은 데이터";
		model.addAttribute("message", message);
		return "hello";
	}
}
