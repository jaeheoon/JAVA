package ezen.oop.ams;
/*
 * 1차원 배열을 이용한 계좌 목록 관리
 */
public class AccountApp {

	public static void main(String[] args) {
		Account[] accounts = new Account[100];
		
		
		int index = 0;
//		새로운 게좌 등록(개설)
		Account account = new Account("홍재헌", 1111, 100000);
		accounts[index++] = account;
		
		Account account2 = new Account("이희영", 1111, 1000000);
		accounts[index++] = account2;
		
		Account account3 = new Account("김기정", 1111, 10000000);
		accounts[index++] = account3;
		
		System.out.println("-------------------전체 계좌 조회-----------------------------------");
//		전체 계좌 목록 조회
		for (int i = 0; i < index; i++) {
			accounts[i].printInfo();
		}
		System.out.println("전체 등록되어있는 계좌의 갯수는 :"+index+"개 입니다.");
		System.out.println("-------------------계좌 번호 검색 결과------------------------------");
		
//		계좌번호로 계좌 검색
		String searchName = "1001";
		for (int i = 0; i < index; i++) {
			if(accounts[i].getAccountNum().equals(searchName)) {
				account.printInfo();
			}
		}
		
//		명시적 생성
		String str1 = new String("김기정 바보");
		String str2 = new String("김기정 바보");
		System.out.println(str1==str2);
//		묵시적 생성
		String str3 = "김기정 바보";
		String str4 = "김기정 바보";
		System.out.println(str3==str4);
		
		
		
		
	}

}
