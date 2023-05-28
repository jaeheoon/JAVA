package ezen.oop.inheritence;

import ezen.oop.ams.Account;
import ezen.oop.ams.AccountRepository;
import ezen.oop.ams.MinusAccount;

public class PolymophismExample {

	public static void main(String[] args) {
//		클래스 자동형변환
		Shape shape; // = new Shape(); - 이렇게 생성할 수도 있지만
//		같은 변수이름이지만 생성자를 다르게 생성하면 다양하게 생성할 수 있다
//		shape = new Shape(10, 10);												- 추상클래스로 만든 것이기 때문에 삭제
		
		shape = new Circle(10, 10, 100);
		shape.draw();
		
		shape = new Lectangle(10, 10, 100, 300);
		shape.draw();
		
//		매개변수 자동형변환
		SomeClass some = new SomeClass();
//		some.showShape(new Shape());											- 추상클래스로 만든 것이기 때문에 삭제
		some.showShape(new Circle(10, 10, 30));
		some.showShape(new Lectangle());
		
//		자동형변환을 이용해서 같은 함수이지만 매개변수를 다양하게 해서 계좌생성, 마이너스계좌 생성을 하였다
		AccountRepository repository = new AccountRepository();
		repository.addAccount(new Account("홍재헌", 1111, 100000));
		repository.addAccount(new Account("김기정", 1111, 100000));
		repository.addAccount(new MinusAccount("홍재헌", 1111, 100000, 100000000));
		repository.addAccount(new MinusAccount("김기정", 1111, 100000, 100000000));
		
		Account[] list = repository.getAccounts();
			for (int i = 0; i < repository.getCount(); i++) {
				if (list[i] instanceof MinusAccount) {
					System.out.println("마이너스계좌\t"+list[i]+" ");
				}
				else {
					System.out.println("입출금계좌\t"+list[i]+" ");
				}
		}
		
		String message1 = "Java King";
		String message2 = "Java King";
		System.out.println(message1.equals(message2));
//		Object에 있는 것들도 오버라이딩 하면 변경된다, 지금은 계좌가 다르기 때문에 equals가 안먹는 것
		Account account1 = new Account("홍재헌", 1111, 100000);
		Account account2 = new Account("홍재헌", 1111, 100000);
		System.out.println(account1.equals(account2));
		
//		강제형변환
		Account account3 = new MinusAccount("홍재헌", 1111, 100000, 1000000);
//		자동형변환의 경우 자식클래스에서 재정의한 메소드인 경우 호출 가능
		System.out.println(account3.getRestMoney());
//		추가된 메소드 호출이 가능하도록 강제형변환 필요
//		강제형변환 이후 getBorrowMoney메소드를 사용할 수 있게됨
		MinusAccount account4 = (MinusAccount)account3;
		System.out.println(account4.getBorrowMoney());
		
		
		Account searchAccount = repository.searchAccount("1002");
		System.out.println(searchAccount);
		
//		searchAccount에 검색된 계좌 1002번의 대출금액 확인하는 것
//		instanceof 연산자는 true/false로 반환되고 자식 클래스가 부모 클래스에 있는지 확인 후 리턴해주는 연산자
		if (searchAccount instanceof MinusAccount) {
			account4 = (MinusAccount)searchAccount;
			System.out.println(account4.getBorrowMoney());
		}
		
		
	}

}
