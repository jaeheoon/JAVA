package com.ezen.springbasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springbasic.guestbook.Guestbook;
import com.ezen.springbasic.guestbook.GuestbookService;

@SpringBootTest
public class GuestbookServiceTest {

	@Autowired
	GuestbookService guestbookService;
	
	@Test
	public void registerTest() {
		Guestbook guestbook = Guestbook.builder()
			.writer("꼴뚜기")
			.message("맛있어요")
			.build();
		guestbookService.register(guestbook);
	}
}
