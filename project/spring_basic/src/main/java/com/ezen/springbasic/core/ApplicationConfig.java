package com.ezen.springbasic.core;

import org.springframework.context.annotation.ComponentScan;

/**
 * 애플리케이션에 관계된 구현 객체 생성 및 관계 설정을 책임지는 별도의 조립 클래스 작성
 * @author 홍재헌
 * Spring 이용하여 작성
 */
@ComponentScan(basePackages = "com.ezen.springbasic")
public class ApplicationConfig {
	
	/*	@ComponentScan을 사용하기 전에 @Configuration 사용하여 생성할때 예제
	@Bean
	public Weapon weapon() {
//		return new Gun();
		return new Sword();
	}
	
	@Bean
	public Unit unit() {
		return new Marine(weapon());
	}
	*/
}
