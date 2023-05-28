import ezen.oop.ams.Account;

/*
 * Call by value 개념
 */
public class CallByValueExample {

	public static int sum(int x, int y) {
		x += 50;
		return x+y;
	}
	
	public static void doTask(Account accont) {
		accont.deposit(500000);
	}
	
	public static void main(String[] args) {
		int x = 50, y = 60;
		
//		Call by Value
//		x가 가지고 있는 50이라는 값과 y가 가지고 있는 60이라는 값이 전달됨
		int result = sum(x, y);
		System.out.println(result);
		System.out.println(x);
		
		Account account = new Account("홍재헌", 1111, 10000);
//		Call by Value
		doTask(account);
		long restMoney = account.getRestMoney();
		System.out.println("현재 잔액 : "+ restMoney);
	}

}
