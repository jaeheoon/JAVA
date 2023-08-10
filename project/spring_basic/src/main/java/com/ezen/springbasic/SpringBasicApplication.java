package com.ezen.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ezen.springbasic.core.Unit;

@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {
		
		// 설정파일 없이 스프링 컨테이너 생성 - 얘가 만들어줌
		ConfigurableApplicationContext springContainer = SpringApplication.run(SpringBasicApplication.class, args);
		Unit unit = springContainer.getBean(Unit.class);
		unit.offense();
	}

}
