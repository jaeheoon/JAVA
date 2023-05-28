/*
 * 일상생활의 강아지(객체)를 프로그램으로 표현한 클래스
 * 객체 추상화 클래스
 */
public class Dog {
//	인스턴스 변수 - 클래스에 선언되는 변수 - 필드라고 함
	private String name, type;
	private int age;
	
//	컴파일러에 의해 자동 생성되는 디폴트 생성자
//	생성자 안만들 시 컴파일러가 자동적으로 null;로 초기화시킨다.
//	개발자가 정의하는 생성자
	Dog(){														//매개변수를 안받는 타입
		name = null;
		type = null;
		age = 0;
	}
	
//	생성자에 의해 초기화하지않은 인스턴스 변수는 JVM에 의해 실행 시 자동으로 초기화된다.
//	정수(byte, short, int, long) : 0
//	실수(float, double) : 0.0
//	문자(char) : 0
//	논리값(boolean) : false
//	참조형 : null
	public Dog(String name, String type) {					//매개변수를 두개만 받는 타입
//		this.name = name;
//		this.type = type;
		
//		this()를 이용해 코드 간략화 진행
		this(name, type, 0);
	}
	
	public Dog(String name, int age) {						//매개변수를 두개만 받는 타입
//		this.name = name;
//		this.age = age;
		this(name, null, age);
	}

	
//	생성자 오버로딩 - 생성자 종류를 중복해서 여러가지로 만들 수 있다는 것을 보여줌
	public Dog(String name, String type, int age) {			//매개변수를 세개 받는 타입
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	
//	은닉화 후 Setter, Getter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

//	인스턴스 메소드 - 객체가 가지는 메소드
	void bark() {
		System.out.println(name + "강아지가 왈왈 짖습니다.");
	}
	
	void eat() {
		System.out.println(name + "강아지가 먹이를 먹습니다.");
	}
}
