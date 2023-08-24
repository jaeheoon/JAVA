package com.ezen.springmvc.domain.member.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Member Service가 동작할때마다 로그 찍어주는 클래스 AOP 개념 적용
 * @author 홍재헌
 */
@Component
@Aspect
@Slf4j
public class LogAspact {
	
	@Before("execution(* com.ezen.springmvc.web..*(..))")
	public void beforeLog() {
		log.info("----------------- 세부 컨트롤러 호출 됨 -----------------");
	}
	
	@After("execution(* com.ezen.springmvc.web..*(..))")
	public void AfterLog() {
		log.info("----------------- 세부 컨트롤러 실행 종료 -----------------");
	}
	
	@AfterReturning(pointcut = "execution(* com.ezen.springmvc.web..*(..))", returning = "returnValue")
	public void AfterReturnLog(Object returnValue) {
		log.info(">> 세부 컨트롤러 실행 후 반환값 : {}", returnValue);
	}
	
	@Around("execution(* com.ezen.springmvc.web..*(..))")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().toShortString();
		
		Object[] argsList = joinPoint.getArgs();
		
		try {
			return joinPoint.proceed();
		} finally {
			log.info(">> 세부 컨트롤러 이름 : {}", className);
			log.info(">> 세부 컨트롤러 메소드 이름 : {}", methodName);
			
			for (Object object : argsList) {
				log.info(">> 전달 인자 : {}", object);
			}
		}
	}
}
