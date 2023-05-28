/*
 * 조건문 if
 */
public class IFExample {

	public static void main(String[] args) {
//		int score = 88;
//		String avg = score >= 60 ? "참 잘했어요" : "다시하세요";
//		System.out.println(avg); 
//		랑 같은 구절
		
		int score = 88;
		
		if (score>=60) {
			System.out.println("참 잘했어요");
		}
		else {
			System.out.println("다시하세요");
		}
		
//		if문 사용하여 홀, 짝 구분하는 방법
		int num = 55;
		if ((num % 2) == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");

		}
		
//		다중 if문
		if (score>=90) {
			System.out.println("수");
		} 
		else if(score>=80){
			System.out.println("우");
		}
		else if(score>=70){
			System.out.println("미");
		}
		else if(score>=60){
			System.out.println("양");
		}
		else {
			System.out.println("가");
		}
		
	}
	
}
