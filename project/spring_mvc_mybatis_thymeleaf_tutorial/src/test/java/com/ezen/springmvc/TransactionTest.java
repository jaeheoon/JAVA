package com.ezen.springmvc;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ezen.springmvc.transaction.TransactionDemoService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TransactionTest {
	// 실제 서비스 객체 대신에 트랜잭션을 관리해주는 트랜잭션 동적 프록시 객체가 주입된다.
	@Autowired
	private TransactionDemoService service;
	
	@Test
	@Disabled
	public void applyTransactionTest() {
		log.info("주입받은 서비스 객체: {}", service.getClass().getName());
		service.applyTransction();
	}
	
	@Test
	@Disabled
	public void noApplyTransactionTest() {
		service.nonApplyTransction();
	}
	
	@Test
	public void someRegistTest() {
		service.someList();
	}
}






