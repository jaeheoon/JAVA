/*
 * 애플리케이션(메인) 클래스
 */
public class DogExample {

	public static void main(String[] args) {
//		지역변수, 기본 데이터 타입
		int age;
		age = 8;
		
//		지역변수, 레퍼런스 데이터 타입
//		메모리상에 Dog 인스턴스 생성
		Dog dog;
		dog = new Dog();
		dog = new Dog("루니", "비숑", 8);
		
//		디폴트 생성자 호출을 이용한 인스턴스 생성
//		dog = new Dog();  - 이건 개발자가 생성한 생성자를 만들지 않았을때 사용
		

		System.out.println(dog.getName());
		System.out.println(dog.getType());
		System.out.println(dog.getAge());
		
//		레퍼런스.메소드;
		dog.bark();
		dog.eat();
		
//		인스턴스의 속성(상태) 변경
//		dog.name = "루니";				//- 생성자 생성 전
//		dog.type = "비숑";
//		dog.age = 8;
		dog.setName("루니");			//- 생성자 생성 후
		dog.setType("비숑");
		dog.setAge(8);

		
//		System.out.println(dog.name);
//		System.out.println(dog.type);
//		System.out.println(dog.age);
		System.out.println(dog.getName());
		System.out.println(dog.getType());
		System.out.println(dog.getAge());
		dog.bark();
		
		/*
		Dog dog2 = new Dog();
		dog2.name = "복돌이";
		dog2.type = "믹스";
		dog2.age = 16;
		dog2.bark();
		
		Dog dog3 = new Dog("메리", "진돗개");
		System.out.println(dog3.name);
		System.out.println(dog3.type);
		System.out.println(dog3.age);
		*/
		
		
	}

}
