class VariableExample {
	public static void main(String[] args) {

		// 변수는 프로그램에서 사용하는 데이터를 저장하기 위한 메모리 공간
		// 변수를 사용하는 목적 : 데이터를 재사용하기 위함
		// 변수 선언
		String name;   //String - 문자열
		int age;	   //int - 정수형
		double weight; //double - 실수형
		
		// 변수 초기화
		name = "홍재헌";
		age = 30;
		weight = 70.3;
		
		// 변수 사용
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);

		// 변수의 값을 수정(Update)
		name = "재헌";
		age = 26;
		weight = 67.1;

		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);
		
		// 변수에 변수의 값 할당
		int age2;
		age2 = age/2;
		System.out.println(age2);

		// 변수 선언과 할당을 동시에
		int score = 97;
		System.out.println("학생의 성적은 "+score+"점");

		/*
		int a;
		int b;
		int c;
		int d; 와
		int a, b, c, d;는 같다

		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40; 와
		int a = 10, b = 20, c = 30, d = 40;는 같다
		*/

		/*초기화 되지 않은 변수는 사용할 수 없다.
			ex) int x;
			System.out.println(x); 
		*/
		String firstName = "재헌"; // Carmel 표기법 : 두 개의 단어 이상이 합해져있을때 섞여진 첫 단어의 문자는 대문자로 표기
		String lastName = "홍";
		System.out.println(lastName+" "+firstName);

		/*
		자바 예약어(키워드)는 변수명으로 사용할 수 없다.
		ex) int this; int public;
		*/
		
	}
}
