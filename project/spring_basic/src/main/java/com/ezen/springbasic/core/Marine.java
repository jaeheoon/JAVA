package com.ezen.springbasic.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("unit")
public class Marine implements Unit {
	
//	@Qualifier("sword")
	final Weapon weapon;
	
	public Marine(Weapon weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public void offense() {
		weapon.attack();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("생성된 후 프로그램 작업 실행");
	}
}
