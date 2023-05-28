/*
 * 반복문 while
 */
public class WhileExample {

	public static void main(String[] args) {
		int i = 1, sum = 0;
		while (i<=100) {
			sum += i;
			i++;
				
		}
		System.out.println(sum);
	
//			i = 1; sum = 0;
//			while (i<=100) {
//				i+=2;
//				sum += i-1;
//			}
//			System.out.println("짝수의 합은 : " + sum);
//			
//			
//			i = 1; sum = 0;
//			while (i<=100) {
//				sum += i;
//				i+=2;
//				
//			}
//			System.out.println("홀수의 합은 : " + sum);
		
		int oddSum = 0, evenSum = 0;
		sum = 0; i = 1;
		while (i<=100) {
			if ((i%2)==0) {
				evenSum += i;
			} 
			else {
				oddSum += i;
			}
				i++;
			}
			System.out.println("짝수의 합은 : " + oddSum);
			System.out.println("홀수의 합은 : " + evenSum);
		
		
//			do while문
			
			i = 0;
			do {
				System.out.println("풀스택 웹 개발자과정 파이팅!");
				i++;
			} while (i<10);
		}
}
