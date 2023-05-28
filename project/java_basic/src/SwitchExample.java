/*
 * 조건문 Switch
 */
public class SwitchExample {

	public static void main(String[] args) {
		
		
//		switch문은 case가 일치하면 구절 밖으로 나오는 것이 아닌 차례대로 실행함
//		따라서 break도 같이 써줘야함

		int num = 4;
		switch (num) {
			case 1: System.out.println("1입니다."); break;
			case 2: System.out.println("2입니다."); break;
			case 3: System.out.println("3입니다."); break;
			case 4: System.out.println("4입니다."); break;
			case 5: System.out.println("5입니다."); break;
			default:System.out.println(num+"입니다.");
		}
		
		char some = 'c';
		switch (some) {
			case 'a':System.out.println("1입니다.");break;
			case 'b':System.out.println("2입니다.");break;
			case 'c':System.out.println("3입니다.");break;
			case 'd':System.out.println("4입니다.");break;
			case 'e':System.out.println("5입니다.");break;
			default: System.out.println(some+"입니다.");
		}
		
		int score = 95;
		switch (score/10) {
			case 10:
			case 9: System.out.println("수");break;
			case 8: System.out.println("우");break;
			case 7: System.out.println("미");break;
			case 6: System.out.println("양");break;
			default:System.out.println("가");
		}
		
		int x = 50, y = 30;
		char operator = '-';
		switch (operator) {
		case '+':System.out.println("덧셈 = " + (x + y));break;
		case '-':System.out.println("뺄셈 = " + (x - y));break;
		case '*':System.out.println("곱셈 = " + (x * y));break;
		case '/':System.out.println("나눗셈 = " + (x / y));break;
		}
		
	}
}
