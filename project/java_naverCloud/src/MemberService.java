package homework;

import java.util.Scanner;

/**
 * 클래스 활용하여 DTO, Service 회원 생성 프로그램 구현
 * @author 홍재헌
 *
 */
public class MemberService {
	private MemberDTO[] memberDTO = new MemberDTO[5];
	private Scanner sc = new Scanner(System.in);
	private int count = 0;
	
//	메뉴 출력
	public void menu() {
		int check = 0;
		String yn = "";
		do {
			System.out.println("*************");
			System.out.println("   1. 가입");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 탈퇴");
			System.out.println("   5. 끝내기");
			System.out.println("*************");
			System.out.println();
			System.out.print("번호 입력 : ");
			check = sc.nextInt();
			if(check == 1) insert();
			if(check == 2) list();
			if(check == 3) update();
			if(check == 4) delete();
			if(check == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			do {
				System.out.print("다시 실행하시겠습니까(Y/N) : ");
				yn = sc.next();
			} while (!yn.equals("Y") && !yn.equals("y") && !yn.equals("N") && !yn.equals("n"));
			if(yn.equals("N") || yn.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} while(check != 5);
	}
	
//	리스트 출력
	public void list() {
		if(count > 0) {
			for (int i = 0; i < count; i++) {
				System.out.println(memberDTO[i].getName() + "\t"
								  +memberDTO[i].getAge() + "\t"
								  +memberDTO[i].getPhone() + "\t"
								  +memberDTO[i].getAddress());
			}
		} else {
			System.out.println("리스트에 사람이 없습니다.");
		}
	}
	
//	회원가입
	public void insert() {
		if(count > 5) {
			System.out.println("5명의 정원이 꽉찼습니다.");
			return;
		}
		memberDTO[count] = new MemberDTO();
		System.out.println(count);
		System.out.print("이름 : ");
		memberDTO[count].setName(sc.next());
		System.out.print("나이 : ");
		memberDTO[count].setAge(sc.nextInt());
		System.out.print("핸드폰 : ");
		memberDTO[count].setPhone(sc.next());
		System.out.print("주소 : ");
		memberDTO[count].setAddress(sc.next());
		count++;
		System.out.println("회원가입이 되었습니다.");
	}
	
//	회원 정보 수정
	public void update() {
		String phoneNum = "";
		int sel = 0;
		System.out.print("수정하고싶은 핸드폰 번호 입력 : ");
		phoneNum = sc.next();
		for (int i = 0; i < count; i++) {
			if(phoneNum.equals(memberDTO[i].getPhone())) {
				System.out.print("수정 할 이름 : ");
				memberDTO[i].setName(sc.next());
				System.out.print("수정 할 나이 : ");
				memberDTO[i].setAge(sc.nextInt());
				System.out.print("수정 할 핸드폰 : ");
				memberDTO[i].setPhone(sc.next());
				System.out.print("수정 할 주소 : ");
				memberDTO[i].setAddress(sc.next());
				System.out.println("회원의 정보를 수정하였습니다.");
				sel++;
			} else if(sel == 0){
				System.out.println("찾는 회원이 없습니다.");
			}
		}
	}
	
//	회원 정보 삭제
	public void delete() {
		String phoneNum = "";
		int sel = 0;
		System.out.print("삭제하고싶은 핸드폰 번호 입력 : ");
		phoneNum = sc.next();
		for (int i = 0; i < count; i++) {
			if(phoneNum.equals(memberDTO[i].getPhone())) {
				memberDTO[i].setName(null);
				memberDTO[i].setAge(0);
				memberDTO[i].setAddress(null);
				memberDTO[i].setPhone(null);
				count--;
				System.out.println("회원의 정보를 삭제하였습니다.");
			} else if(sel == 0) {
				System.out.println("찾는 회원이 없습니다.");
			}
		}
	}
}
