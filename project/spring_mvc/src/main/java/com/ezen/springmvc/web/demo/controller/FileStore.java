package com.ezen.springmvc.web.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

//업로드 된 파일 저장 및 관리
@Component
@Slf4j
public class FileStore {
	@Value("${file.dir}")
	private String location;

	public String getFullPath(String filename) {
		return location + filename;
	}

	//파일 저장
	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) {
				//업로드 파일 저장
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}

//	중복파일 처리 메소드
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String storeFileName = createStoreFileName(originalFilename);
		log.info("사용자가 업로드한 파일명 : {}", originalFilename);
		log.info("실제 저장된 파일명 : {}", storeFileName);
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		return new UploadFile(originalFilename, storeFileName);
	}

//	중복파일 있을 시 새로운 파일 이름으로 생성해주는 메소드
//	UUID : 중복되지않는 식별자로 생성해주는 클래스
	private String createStoreFileName(String originalFilename) {
		String ext = extractExt(originalFilename);
		String uuid = UUID.randomUUID().toString();
		return originalFilename + "-" + uuid + "." + ext;
	}

//	순수 파일 이름만 잘라오는 메소드
	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		return originalFilename.substring(pos + 1);
	}
}
