class IntegerExample {
	public static void main(String[] args) {
		// 정수의 다양한 표기법
		int num1 = 128;    //10진수 표기법
		int num2 = 0b01011111; //2진수 표기법
		int num3 = 025;    //8진수 표기법
		int num4 = 0x10AB;     //16진수 표기법

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);

		long balace = 11111111111L; // long타입은 뒤에 L을 붙여줘야함, 소문자도 가능하긴 한데 헷갈리기때문에 대문자로 붙임
		float balace2 = 0.111F;     // float타입은 뒤에 F를 붙여줘야함
		System.out.println(balace);

		byte x = -128;
		byte y = 127;  // 양수는 127까지 가능 ? 도 포함되기 때문

		double t = 3.0123456789123456789; //double은 소숫점 15자리까지만 가능
		System.out.println(t);
	}
}
