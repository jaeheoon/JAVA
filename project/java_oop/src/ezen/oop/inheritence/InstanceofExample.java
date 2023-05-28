package ezen.oop.inheritence;

import ezen.oop.ams.Account;
import ezen.oop.ams.MinusAccount;

/**
 * Instanceof 사용 시 주의사항
 * @author user
 *
 */

public class InstanceofExample {

	public static void main(String[] args) {
//		instanceof 사용 시 주의사항, 
//		서로 다른 클래스가 아닌 부모, 자식 클래스면 무조건 같다고 나온다
//		따라서 비교할때, 항상 자식부터 비교해야함(구체적인 것부터) 왜냐하면 위에서 부모부터 하면 부모도 같다고 나오기 때문에 다 true로 나온다
		
		MinusAccount minusAccount = new MinusAccount();
		System.out.println(minusAccount instanceof MinusAccount);
		System.out.println(minusAccount instanceof Account);
		System.out.println(minusAccount instanceof Object);
		
	}

}
