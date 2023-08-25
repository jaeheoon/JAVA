package com.ezen.springmvc;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ezen.springmvc.transaction.Order;
import com.ezen.springmvc.transaction.OrderMapper;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OrderMapperTest {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	@Disabled
	public void createTest() {
		Order order = Order
				.builder()
				.memberId("cangry")
				.build();
		orderMapper.create(order);
		log.info("주문 완료 : {}", order);
	}
}


