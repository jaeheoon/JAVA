package com.ezen.springbasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springbasic.core.Unit;

@SpringBootTest
public class SpringApplicationTest {
	
	@Autowired
	Unit unit;
	
	@Test
	public void offenseTest() {
		unit.offense();
	}
}
