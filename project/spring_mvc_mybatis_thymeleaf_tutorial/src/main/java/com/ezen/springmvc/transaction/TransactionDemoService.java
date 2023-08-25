package com.ezen.springmvc.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionDemoService {
	
	private final TransactionDemo2Service demo2Service;
	
	@Transactional
	public void applyTransction() {
		// 현재 비즈니스 메소드에 트랜잭션이 적용되어 있는지 확인
		// 트랜잭션 동기화 매니저를 통해 결과가 true면 트랜잭션이 적용됨을 의미한다.
		boolean txActive = false;
		txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  활성화 상태 = {}", txActive);
	}
	
	public void nonApplyTransction() {
		boolean txActive = false;
		txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  활성화 상태 = {}", txActive);
	}
	
	public void someList() {
		log.info("someList() 호출됨...");
		printTransactionActived();
		// 트랜잭션 테스트를 위한 내부 호출
		//someUpdate(); // 트랜잭션이 적용되지 않는다. - 직접 호출하면 프록시 객체로 적용이 안되기 때문에 따로 클래스를 분리하여 호출해준다
		demo2Service.someUpdate();
	}
	
	@Transactional
	public void someUpdate() {
		log.info("someUpdate() 호출됨...");
		printTransactionActived();
	}
	
	// 트랜잭션 적용 확인을 위한 헬퍼 메소드
	private void printTransactionActived() {
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  활성화 상태 = {}", txActive);
	}
}




