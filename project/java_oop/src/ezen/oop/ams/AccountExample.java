package ezen.oop.ams;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account("김기정", 1111, 10000);
		System.out.println(account);
		
		MinusAccount ma = new MinusAccount("김기정", 1111, 10000, 1000000000);
		System.out.println(ma);
	}

}
