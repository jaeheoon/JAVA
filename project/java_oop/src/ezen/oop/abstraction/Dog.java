package ezen.oop.abstraction;

public class Dog extends Animal {
//	필요에 따라서 필드 추가 가능
	
	public Dog() {};
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	};
	
	@Override
	public void eat() {
		System.out.println("강아지가 사료를 먹습니다.");
		
		
	}

	@Override
	public void sleep() {
		System.out.println("강아지가 웅크려 잡니다.");
		
		
		
		
	}	

	@Override
	public void walk() {
		System.out.println("강아지가 귀엽게 걷습니다.");
		
		
		
		
	}

}
