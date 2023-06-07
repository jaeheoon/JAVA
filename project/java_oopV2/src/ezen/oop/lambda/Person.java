package ezen.oop.lambda;

public class Person {
	
	public void action(Workable workable) {
		workable.work();		
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		
		person.action(() -> {
			// 실행문이 두 개 이상일 경우 중괄호 필요
			System.out.println("출근합니다...");
			System.out.println("열라 코딩합니다..");
		});
		
		person.action(() -> System.out.println("한량입니다.."));
		
	}

}
