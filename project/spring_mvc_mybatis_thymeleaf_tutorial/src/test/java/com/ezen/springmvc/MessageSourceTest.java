package com.ezen.springmvc;

import java.util.Locale;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MessageSourceTest {
	
	@Autowired
	private MessageSource messageSource;
	
	@Test
//	@Disabled
	void messageTest() {
//		getMessage(키값, 전달인자, 디폴트 값(키값이 없을때))
		String message = messageSource.getMessage("member.title.register",null, null);
		log.info("message : {}", message);
	}
	
	@Test
//	@Disabled
	void messageParamTest() {
		String message = messageSource.getMessage("hello.name",new Object[]{"김기정"}, null);
		log.info("message : {}", message);
	}
	
	@Test
	void messageDefaultTest() {
//		getMessage(키값, 전달인자, 디폴트 값(키값이 없을때), 국제화처리때 사용)
		String message = messageSource.getMessage("hello.id",new Object[]{"김기정"}, "손님", null);
		log.info("message : {}", message);
	}
	
	@Test
	@DisplayName("국제화 처리 테스트")
	void messageInternationalTest() {
		String message = messageSource.getMessage("hello.name",new Object[]{"김기정"}, "손님", Locale.ENGLISH);
		log.info("message : {}", message);
	}
	
}

