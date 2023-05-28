/*
 * 이동문 Lable
 */
public class LableExample {

	public static void main(String[] args) {
		
//		Lable은 관례로 올 대문자로 사용함
		OUT:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i+", "+j);
				if (j==5) {
//					break;
					break OUT;
				}
			}
		}
	
	}
}
