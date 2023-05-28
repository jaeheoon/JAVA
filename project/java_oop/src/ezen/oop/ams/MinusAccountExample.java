package ezen.oop.ams;
/**
 * 상속을 이용한 마이너스통장 생성해보기
 * @author 홍재헌
 *
 */
public class MinusAccountExample {

	public static void main(String[] args) {
		
//		부모클래스로부터 상속받은 필드 및 메소드 재사용
		MinusAccount minusAccount = new MinusAccount("김대출", 1111, 10000, 100000000);
//		부모클래스의 메소드 재사용
		String accountNum = minusAccount.getAccountNum();
		System.out.println(accountNum);
//		추가된 메소드 사용
		System.out.println(minusAccount.getBorrowMoney());
//		재정의된 메소드 사용
		System.out.println(minusAccount.getRestMoney());
		
		Account account = new Account("김기정", 1111, 10000);
		account.equals(account);
	}

}
