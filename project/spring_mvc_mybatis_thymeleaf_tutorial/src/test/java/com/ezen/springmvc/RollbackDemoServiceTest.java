package com.ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.transaction.MyException;
import com.ezen.springmvc.transaction.RollbackDemoService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
public class RollbackDemoServiceTest {
	@Autowired
	private RollbackDemoService service;
	
	@Test
	void throwRuntimeException() {
		service.throwRuntimeException();
	}
	@Test
	void throwCompilecheckedException() throws MyException {
		service.throwCompilecheckedException();
	}
	@Test
	void throwCompilecheckedException2() throws MyException {
		service.throwCompilecheckedException2();
	}
}






