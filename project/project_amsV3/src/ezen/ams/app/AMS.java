package ezen.ams.app;

import java.util.List;
import java.util.Scanner;
import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.ListAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.exception.NotBalanceException;

public class AMS {
	
	private static AccountRepository repository = new ListAccountRepository();
	private static Account accounts;
	private static Scanner scanner = new Scanner(System.in);
	
	private static int accountType = 0, passwd = 0, selectNo = 0;
	private static String owner = null;
	private static long inputMoney = 0, borrowMoney = 0;
	private static boolean run = true;
	
	public static void main(String[] args) throws NotBalanceException {
		System.out.println("*****************************************");
		System.out.println("** "+Account.BANK_NAME+"은행 계좌 관리 애플리케이션 **");
		System.out.println("*****************************************");
		accountType();
		
			while (run) {
				if (accountType == 3) {
					break;
				} else if (accountType > 3) {
					System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주시기 바랍니다");
					accountType();
					continue;
				}
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("  1.계좌생성  |  2.계좌목록  |  3.입금  |  4.출금  |  5.메뉴  |  6.종료  ");
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.print("선택> ");
				
				selectNo = Integer.parseInt(scanner.nextLine());
				if (selectNo == 1) {
					// 계좌 생성 및 등록
					createAccount();
				} else if (selectNo == 2) {
					// 계좌목록
					printAccounts();
				} else if (selectNo == 3) {
					// 입금
					addRestMoney();
				} else if (selectNo == 4) {
					// 출금
					widthRestMoney();
				} else if (selectNo == 5) {
					//메뉴로 돌아가기
					accountType();
					if (accountType == 3) {
						break;
					}
				} else if (selectNo == 6) {
					run = false;
				} else if (selectNo == 7) {
					dummiData();
				}
			}
		scanner.close();
		System.out.println("계좌관리 애플리케이션을 종료합니다.");
		}
	
		/**
		 * 계좌 종류 판별
		 */
		private static void accountType() {
			System.out.println("계좌 종류(1: 입출금 계좌, 2: 마이너스 계좌 3: 종료)");
			System.out.print("계좌 종류를 입력하세요: ");
			accountType = Integer.parseInt(scanner.nextLine());
		}
		
		/**
		 * 테스트를 위한 임시 데이터 생성
		 * @throws NotBalanceException 
		 */
		private static void dummiData() throws NotBalanceException {
			System.out.println("테스트를 위한 임시 데이터를 생성합니다");
			repository.addAccount(new Account("김기정", 1111, 10000000));
			repository.addAccount(new Account("홍재헌", 1111, 1000000));
			repository.addAccount(new Account("김재헌", 1111, 1000000));
			repository.addAccount(new Account("최재헌", 1111, 1000000));
			repository.addAccount(new Account("양재헌", 1111, 1000000));
			repository.addAccount(new MinusAccount("양재헌", 1111, 1000000, 10000000));
			repository.addAccount(new MinusAccount("양재헌", 1111, 1000000, 10000000));
			repository.addAccount(new Account("양재헌", 1111, 1000000));
			System.out.println("생성 완료");
		}
	
		/**
		 * 키보드(표준입력)로부터 계좌정보 입력 받아 계좌생성하기
		 */
		private static void createAccount() {
				System.out.print("입출금계좌 예금주명: ");
				owner = scanner.nextLine();
				
				System.out.print("비밀번호: ");
				passwd = Integer.parseInt(scanner.nextLine());
				
				System.out.print("입금액: ");
				inputMoney = Long.parseLong(scanner.nextLine());
				
				if (accountType == 2) {
					System.out.print("대출금액: ");
					borrowMoney = Long.parseLong(scanner.nextLine());
				}
				try {
					if (accountType == 1) {
						accounts = new Account(owner, passwd, inputMoney);
					} else if (accountType == 2) {
						accounts = new MinusAccount(owner, passwd, inputMoney, borrowMoney);
					} 
					System.out.println("※ 계좌가 정상 등록 처리되었습니다.");
				} catch (NotBalanceException e) {
					System.err.println(e);
					System.err.println("계좌 등록을 다시 해주시기 바랍니다.");
					System.out.println("");
				}
				
				// AccountRepository에 계좌등록
				repository.addAccount(accounts);
		}
		/**
		 * 입출금 계좌 입금하기
		 */
		private static void addRestMoney() {
			System.out.print("계좌번호를 입력하세요: ");
			String accountNum = scanner.nextLine();
			accounts = repository.searchAccount(accountNum);
			if(accounts!=null) {
				System.out.print("입금할 금액을 입력하세요: ");
				long addMoney = Long.parseLong(scanner.nextLine());
				long addRestMoney = 0;
				try {
					addRestMoney = accounts.deposit(addMoney);
					System.out.println("입금 후 잔액은: " + addRestMoney);
				} catch (NotBalanceException e) {
					System.err.println(e);
				}
			}
			else {
				System.out.println("계좌번호에 해당하는 계좌가 존재하지 않습니다..");
			}
		}
		
		/**
		 * 입출금 계좌 출금하기
		 */
		private static void widthRestMoney() {
			System.out.print("계좌번호를 입력하세요: ");
			String accountNum = scanner.nextLine();
			accounts = repository.searchAccount(accountNum);
			if(accounts != null) {
				System.out.print("비밀번호를 입력하세요: ");
				int accountNumPwd = Integer.parseInt(scanner.nextLine());
				int checkNumPwd = accounts.getPasswd() ;
					if(checkNumPwd==accountNumPwd) {
						System.out.print("출금할 금액을 입력하세요: ");
						long disMoney = Long.parseLong(scanner.nextLine());
						long disRestMoney = 0;
						try {
							disRestMoney = accounts.withdraw(disMoney);
							System.out.println("출금 후 잔액은: " + disRestMoney);
						} catch (NotBalanceException e) {
							System.err.println(e);
						}
					}
					else {
						System.out.println("비밀번호가 다릅니다..");
					}
				}
			else {
					System.out.println("계좌번호에 해당하는 계좌가 존재하지 않습니다.");
				}
			}
		
		/**
		 * 입출금계좌 목록 출력
		 */
		private static void printAccounts()	{
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("    계좌 종류  계좌번호    이름      비밀번호       잔액          대출금액");
			System.out.println("------------------------------------------------------------------------------------------");
			List<Account> list = repository.getAccounts();
			for (Account account : list) {
				if (account instanceof MinusAccount) {
					System.out.println("[마이너스계좌]  "+ account);
				} else if (account instanceof Account) {
					System.out.println("  [입출금계좌]  "+ account);
				} else {
					System.out.println("관리자에게 문의하세요" + account);
				}
			}
		}
}
		








