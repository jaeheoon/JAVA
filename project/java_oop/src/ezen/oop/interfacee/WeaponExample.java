package ezen.oop.interfacee;


public class WeaponExample {

	public static void main(String[] args) {
//		인터페이스는 추상클래스처럼 객체 생성은 안되지만
//		타입선언으로는 가능하다
		
//		인터페이스 사용하기 전 하드코딩
		/*
		Weapon weapon = new Gun();
		weapon.attack();
		
		weapon = new Sword();
		weapon.attack();
		
		weapon = new Club();
		weapon.attack();
		*/
		
//		인터페이스 사용 후 코딩
		Unit unit = new Unit("maine", new Gun());
		unit.offence();
		unit.offence();
		unit.offence();
		unit.offence();
		
		unit.setWeapon(new Sword());
		unit.offence();
		unit.offence();
		unit.offence();
		
		unit.setWeapon(new Club());
		unit.offence();
		unit.offence();
		unit.offence();
		unit.offence();
	}

}
