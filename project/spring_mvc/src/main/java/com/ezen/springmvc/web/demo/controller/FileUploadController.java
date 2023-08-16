package com.ezen.springmvc.web.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * 파일 업로드 요청에 대한 세부 컨트롤러(핸들러)
 * @author 홍재헌
 */
@Controller
@Slf4j
public class FileUploadController {
// application.properties에 설정된 파일 경로
// @Value("D:/JAVA/workspace/spring_mvc/upload/")
	@Value("${file.dir}")
	private String location;

//	파일 업로드 화면 요청
	@GetMapping("/upload")
	public String uploadForm() {
		return "form";
	}

//	파일 업로드 요청 처리
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("uploader") String uploader,
			@RequestParam("uploadfile") MultipartFile uploadfile, Model model) throws IOException {
		log.info("업로더 = {}", uploader);
		log.info("multipartFile = {}", uploadfile);
		
//		isEmpty = 파일이 비어있다는 메소드
		if (!uploadfile.isEmpty()) {
			String fullPath = location + uploadfile.getOriginalFilename();
			log.info("파일 저장 fullPath = {}", fullPath);
			File uploadDir = new File(fullPath);
//			exists = 폴더가 존재한다는 메소드
//			mkdirs = 폴더 생성해주는 메소드
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			uploadfile.transferTo(uploadDir);
			model.addAttribute("uploader", uploader);
			model.addAttribute("uploadfile", uploadfile.getOriginalFilename());
		}
		return "upload-result";
	}
}
