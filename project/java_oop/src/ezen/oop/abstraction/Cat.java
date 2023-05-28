package ezen.oop.abstraction;

public class Cat extends Animal {
//	필요에 따라서 필드 추가 가능
	
	public Cat() {};
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	};
	
	@Override
	public void eat() {
		System.out.println("고양이가 사료를 먹습니다.");
		
		
	}

	@Override
	public void sleep() {
		System.out.println("고양이가 웅크려 잡니다.");
		
		
		
		
	}	

	@Override
	public void walk() {
		System.out.println("고양이가 귀엽게 걷습니다.");
	}
	
//	새로운 기능 추가
	public void jump() {
		System.out.println("고양이가 높이 점프합니다.");
		
	}

}
