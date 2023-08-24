package com.ezen.springmvc.domain.member.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Member Service가 동작할때마다 시간 체크해주는 클래스 AOP 개념 적용
 * @author 홍재헌
 */
@Component
//@Aspect
@Slf4j
public class TimeTraceAspact {
	@Around("execution(* com.ezen.springmvc..*(..))")
	// 공통 기능 메소드
	// 포인트컷 표현식을 이용한 적용 시점 설정
	public Object timeCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().toShortString();
		
		long startTime = System.currentTimeMillis();
		try {
			return joinPoint.proceed();
		} finally {
			long endTime = System.currentTimeMillis();
			long excuteTime = endTime - startTime;
			log.info(className + " 클래스의 "+ methodName +" 메소드 실행 시간 : {}", excuteTime);
		}
	}
}
