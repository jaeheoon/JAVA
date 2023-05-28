package ezen.oop.ams;

public class AMS {

	public static void main(String[] args) {
		System.out.println("*****************************************");
		System.out.println("** "+Account.BANK_NAME+"은행 계좌 관리 애플리케이션 **");
		System.out.println("*****************************************");
		
//		계좌 관리를 위한 AccountRepository 생성
		AccountRepository repository = new AccountRepository();
		
//		신규계좌 등록 테스트
		Account account = new Account("김기정", 1111, 100000000);
		boolean success = repository.addAccount(account);
		if(success) {
			System.out.println("계좌 정상 등록 처리되었습니다.");
		}else {
			System.out.println("계좌 등록 중 에러가 발생하였습니다.");
		}
		
		repository.addAccount(new Account("강소영", 1234, 100000000));
		repository.addAccount(new Account("이희영", 1234, 100000000));
		repository.addAccount(new Account("김기정", 1111, 10000));
		
		
//		전체계좌 조회 테스트
		System.out.println("-------- 전체 계좌 목록 ---------");
		Account[] list = repository.getAccounts();
		for (int i = 0; i < repository.getCount(); i++) {
			list[i].printInfo();			
		}
		
//		계좌번호로 검색 테스트
//		사용자로부터 입력받은 계좌번호라 가정
		System.out.println("-------- 계좌번호로 검색---------");
		String accountNum = "1002";
		Account searchAccount = repository.searchAccount(accountNum);
		if(searchAccount != null) {
			searchAccount.printInfo();
		}else {
			System.out.println("계좌번호에 해당하는 계좌가 존재하지 않습니다..");
		}
		
		
//		예금주명으로 검색 테스트
		System.out.println("-------- 예금주명으로 검색 ---------");
		String accountOwner = "김기정";		
		Account[] searchList = repository.searchAccountByOwner(accountOwner);
		if(searchList != null) {
			for (int i = 0; i < searchList.length; i++) {
				searchList[i].printInfo();
			}
		}else {
			System.out.println("예금주명에 해당하는 계좌가 존재하지 않습니다..");
		}
		
//		계좌번호로 삭제 테스트
		System.out.println("-------- 계좌번호로 삭제 결과 ---------");
		boolean ok = repository.removeAccout("1002");
		if(ok) {
			System.out.println("정상 삭제되었습니다..");
		}else {
			System.out.println("삭제하고자 하는 계좌가 존재하지 않습니다..");			
		}
		
//		삭제 후 전제 조회
		System.out.println("-------- 전체 계좌 목록 ---------");
		list = repository.getAccounts();
		for (int i = 0; i < repository.getCount(); i++) {
			list[i].printInfo();			
		}
				
		
		
		System.out.println("계좌관리 애플리케이션을 종료합니다.");
	}

}








