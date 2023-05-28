package ezen.oop.abstraction;

public class AnimalExample {

	public static void main(String[] args) {
//		추상 클래스는 new 생성자 호출을 이용하여 생상할 수 없다.
//		Animal animal = new Animal();	- 추상클래스는 이런식으로 생성 안함, 자식클래스만 만들기 위한 용도
		
//		추상클래스는 타입 선언으로 가능하다
//		Animal animal = new Dog();
		Animal animal;
		animal = new Dog("루니", 7);
		animal.eat();
		animal.sleep();
		animal.walk();
		
		animal = new Cat();
		animal.eat();
		animal.sleep();
		animal.walk();
		
//		새롭게 추가된 메소드 호출을 위해 강제형변환 필요
		Cat cat = (Cat)animal;
		cat.jump();
		
	}

}
