package ezen.oop.api;

public class WrapperExample {

	public static void main(String[] args) {
//		Integer에 관련된 설명
		int x = 50;
//		Integer integer = new Integer(x);										밑에 코드랑 같은 말인데 생성자 쓰지 말고 밑에 코드로 쓰는 것을 권장
		Integer integer = Integer.valueOf(x);
		byte b = integer.byteValue();											// - byte 타입으로 형변환
		
		String str = "50";
//		System.out.println(value+100);											 - 이때는 문자열이라 +100이 안됨
		int value = Integer.parseInt(str);										// - 문자열을 int형으로 변환
		System.out.println(value+100);
		
		String str2 = "1010";													//2진수로 표현된 것을 10진수로 변경하고 싶을때
		value = Integer.parseInt(str2, 2);										//Integer.parseInt(str2, 2) 이것이 2진수를 10진수로 변경해 주는 것
		System.out.println(value);
		
		int y = 5678;															//10진수로 표현된 것을 2진수로 변경하고 싶을때
		System.out.println(Integer.toString(y, 2));								//Integer.toString(y, 2); 이것이 10진수를 2진수로 변경해 주는 것, 2자리에 8, 16을 넣으면 진수가 변경됨
		System.out.println(Integer.toBinaryString(5000));						//바로 2진수로 변경해주는 것
		System.out.println(Integer.toOctalString(5000));						//바로 8진수로 변경해주는 것
		System.out.println(Integer.toHexString(5000));							//바로 16진수로 변경해주는 것
		
//		Character에 관련된 설명
		char[] data = {'A', 'a', '4',' ', '#'};
		for (int i = 0; i < data.length; i++) {
			if(Character.isUpperCase(data[i])){
				System.out.println(data[i] + "은 대문자이다.");
				}else if(Character.isLowerCase(data[i])){
				System.out.println(data[i] + "은 소문자이다.");
				}else if(Character.isDigit(data[i])){
				System.out.println(data[i] + "은 숫자이다.");
				}else if(Character.isSpaceChar(data[i])){
				System.out.println(data[i] + "은 공백문자이다.");
			}
		}

//		double에 관련된 설명
		Double d = 15.5;
//		System.out.println(d / 0);
		int z = 0;
		input(d/z);
	}
	
		public static void input(double d) {
			if(Double.isInfinite(d)) {
				System.out.println("잘못된 입력값입니다");
				return;
			}
			System.out.println(d + 10);
		}
	
}

