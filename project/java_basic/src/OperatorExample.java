/*
 * 자바에서 지원하는 연산자들
 */
public class OperatorExample {

	public static void main(String[] args) {
		int x = 30, y = 5;
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y);
		
//		%는 나머지 구하는 것, 30/4 = 몫 7, 나머지 2
		y = 4;
		System.out.println(x % y);
		
//		+ 연산자 오버로딩(중복정의)
		System.out.println(10 + 50);
		
//		정수를 문자열로 형 변환 후 결합, 왼쪽에서 오른쪽으로 진행되므로 위치에 따라 달라진다
		System.out.println(30 + 20 + "문자열 " + "결합하기 ");
		System.out.println("문자열 " + "결합하기 " + 30 + 20);
		
//		이때 뒤에 있는 연산을 진행하고 싶으면 소괄호를 넣으면 된다
		System.out.println("문자열 " + "결합하기 " + (30 + 20));
		
//		이 두개는 다르다, 34를 출력하고 싶으면 밑에 있는 수식 사용
		System.out.println("합 = " + x + y);
		System.out.println("합 = " + (x + y));

//		축약을 주로 써야 시간도 절약됨
		System.out.println(x += 10); // x = x + 10 과 같은 의미
		System.out.println(x -= 10); // x = x - 10
		System.out.println(x *= 10); // x = x * 10
		System.out.println(x /= 10); // x = x / 10
		System.out.println(x %= 10); // x = x % 10
		
//		밑 예제를 위한 변수 초기화
		x = 10; 
		y = 5;
		
//		비교연산자(==, !=, >, >=, ...)
		System.out.println(x == y);	//같다
		System.out.println(x != y); //같지않다
		System.out.println(x > y);  //x가 y보다 크다
		System.out.println(x >= y); //x가 y보다 크거나 같다
		
//		증감 연산자(++, --)
		System.out.println(x++); //더하기 전에 보여주고 더한다
		System.out.println(++x); //보여주기 전에 더하고 보여준다
		System.out.println(x--);
		System.out.println(--x);
		
//		조건삼항연산자
		int score = 85;
		String result = score >= 60 ? "통과" : "실패";
		System.out.println(result);
		
//		기본 데이터타입 형변환
//		자동 형변환(promotion - Up Casting - 큰 타입으로 암묵적으로 형 변환)
//		double은 8바이트, 50은 int - 4바이트 -> double로 변환 후 실행
		
		double some = 50; //하지만 형변환은 cpu를 사용하기 때문에 50보단 50.0 이런 식으로 표현하는 것이 좋음
		
//		강제 형변환(demotion - Down Casting - 큰 타입을 작은 타입으로 형 변환)
//		강제 형변환은 데이터 손실이 있을 수 있기때문에 특수한 상황에서 사용, 
//		ex) 85.2432 이러한 값이 있을때 사용자의 요구나 소숫점 자리를 버리고 싶을때 int로 사용
		
		double avg = 85.2432;
		System.out.println(avg);
		System.out.println((int)avg);  //괄호 안에 int로 강제 형변환
		
//		int avg2 = avg; 는 안됨 int avg2 = (int)avg;는 가능
	}
	
}
