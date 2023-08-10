package com.ezen.springbasic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring 이용하여 스프링 컨테이너 생성하기
 * @author 홍재헌
 */
@Slf4j
public class SpringApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		log.info("생성된 스프링 컨테이너 : {}", springContainer);
		
//		Unit unit = (Unit) springContainer.getBean("unit");
//		Unit unit = springContainer.getBean(Unit.class);
		Unit unit = springContainer.getBean("unit", Unit.class);
		
//		스프링 컨테이너에 등록된 모든 빈(자바 객체) 검색
		int count = springContainer.getBeanDefinitionCount();
		String[] names = springContainer.getBeanDefinitionNames();
		log.info("등록된 갯수 : {}", count);
		for (String beans : names) {
			Object bean = springContainer.getBean(beans);
			log.info("등록된 이름들 : {}", bean);
		}
		unit.offense();
		
//		스프링 컨테이너는 빈을 싱글톤으로 관리한다
		Unit unit2 = springContainer.getBean(Unit.class);
//		Unit unit2 = springContainer.getBean("unit", Unit.class);
		log.info("주소값 비교 : {}", unit == unit2);
	}
}
