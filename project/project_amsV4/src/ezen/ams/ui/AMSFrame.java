package ezen.ams.ui;
/**
 * AMS 계좌 그래픽 연동 시스템
 * @author 홍재헌
 * 230523 수업
 */

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.AccountType;
import ezen.ams.domain.JdbcAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.exception.NotBalanceException;
import ezen.ams.util.Validator;

public class AMSFrame extends Frame {
	Button seachB, delteB, checkB, printInfoB, accountSetB;
	Choice accountType;
	TextField accountNumTF, accountOwnerTF, passwdTF, inputMoneyTF, borrowMoneyTF;
	TextArea accountList;
	Label accountTypeL, accountNumL, accountOwnerL, passwdL, inputMoneyL, borrowMoneyL, accontListL, typeL;
	
	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints con = new GridBagConstraints();
	
	private AccountRepository repository;
	
	Account account = null;
	
	public AMSFrame() {
		this("No-Title");
	}
	
	public AMSFrame(String title) {
		super(title);
		
		try {
			repository = new JdbcAccountRepository();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			System.exit(0);
		}
		
		setLayout(grid);
		
		accountTypeL = new Label("계좌종류");
		accountNumL = new Label("계좌번호");
		accountOwnerL = new Label("예금주명");
		passwdL = new Label("비밀번호");
		inputMoneyL = new Label("입금금액");
		borrowMoneyL = new Label("대출금액");
		accontListL = new Label("계좌목록");
		typeL = new Label("(단위 : 원)");
		delteB = new Button("삭 제");
		checkB = new Button("조 회");
		seachB = new Button("검 색");
		accountSetB = new Button("신규등록");
		printInfoB = new Button("전체조회");
		accountType = new Choice();
		accountNumTF = new TextField();
		accountOwnerTF = new TextField();
		passwdTF = new TextField();
		inputMoneyTF = new TextField();
		borrowMoneyTF = new TextField();
		accountList = new TextArea();
		
		con.fill = GridBagConstraints.HORIZONTAL;
		con.insets = new Insets(5, 5, 5, 10);
		
		addCom(accountTypeL, 0, 0, 1, 1, 0.0);
		addCom(accountType, 1, 0, 2, 1, 0.0);
		addCom(accountNumL, 0, 1, 1, 1, 0.0);
		addCom(accountNumTF, 1, 1, 2, 1, 1.0);
		addCom(checkB, 3, 1, 1, 1, 0.0);
		addCom(delteB, 4, 1, 1, 1, 0.0);
		addCom(accountOwnerL, 0, 2, 1, 1, 0.0);
		addCom(accountOwnerTF, 1, 2, 2, 1, 1.0);
		addCom(seachB, 3, 2, 1, 1, 0.0);
		addCom(passwdL, 0, 3, 1, 1, 0.0);
		addCom(passwdTF, 1, 3, 2, 1, 1.0);
		addCom(inputMoneyL, 3, 3, 1, 1, 0.0);
		addCom(inputMoneyTF, 4, 3, 2, 1, 1.0);
		addCom(borrowMoneyL, 0, 4, 1, 1, 0.0);
		addCom(borrowMoneyTF, 1, 4, 2, 1, 1.0);
		addCom(accontListL, 0, 5, 1, 1, 0.0);
		addCom(accountSetB, 3, 4, 1, 1, 0.0);
		addCom(printInfoB, 4, 4, 1, 1, 0.0);
		addCom(typeL, 5, 5, 1, 1, 0.0);
		addCom(accountList, 0, 6, 6, 1, 0.0);
		
		AccountType[] accountTypes = AccountType.values();
		for (AccountType accountT : accountTypes) {
			accountType.add(accountT.getName());
		}
		
		addEventListner();
		pack();
		setVisible(true);
	}

	private void addCom(Component c, int x, int y, int w, int h, double weightx){
//		컴포넌트의 위치 값 설정
		con.gridx= x;
		con.gridy= y;
		con.gridwidth=w;
		con.gridheight=h;
		con.weightx = weightx;
		grid.setConstraints(c, con);
		add(c);
	}
	
//	버튼이 눌렸을때 이벤트
	public void addEventListner() {
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == accountSetB) {			//계좌등록
					addAccount();
				} else if(eventSource == printInfoB) {		//전체계좌 출력
					allList();
				} else if(eventSource == checkB) {			//계좌번호로 조회
					seachAccount();
				} else if(eventSource == delteB) {			//계좌 삭제
					removeAccount();
				} else if(eventSource == seachB) {			//예금주명으로 조회
					seachOwner();
				}
			}
		}
		
//		윈도우창 관련 이벤트
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {				//윈도우 창이 열렸을 때
				allList();
				printReset();
				borrowMoneyTF.setEnabled(false);
				inputMoneyTF.setEnabled(false);
				passwdTF.setEnabled(false);
			}
			
			@Override
			public void windowClosing(WindowEvent e) {				//윈도우 x키 눌렀을때 닫히는 메소드
				((JdbcAccountRepository)repository).close();
				exit();
			}
		});
		
		ActionListener actionListener = new ActionHandler();
		
// 계좌 등록
		accountSetB.addActionListener(actionListener);
		
// 계좌번호로 조회
		checkB.addActionListener(actionListener);
		
// 전체계좌 조회
		printInfoB.addActionListener(actionListener);
		
// 계좌 삭제
		delteB.addActionListener(actionListener);
		
// 예금주명으로 조회
		seachB.addActionListener(actionListener);

// 계좌 선택
		accountType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(accountType.getSelectedItem().equals("입출금계좌")) {
						selectAccountType(AccountType.GENERAL_ACCOUNT);
					} else if(accountType.getSelectedItem().equals("마이너스계좌")) {
						selectAccountType(AccountType.MINUS_ACCOUNT);					
					} else if(accountType.getSelectedItem().equals("전체 계좌")) {
						selectAccountType(AccountType.ALL_ACCOUNT);					
					}
				}
				
			}
		});
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
//	전체 계좌 출력하는 메소드
	public void allList() {
		accountList.setText("");
		printHeader();
		List<Account> list = repository.getAccounts();
		for (Account account : list) {
			if (account instanceof MinusAccount) {
				accountList.append("마이너스계좌     "+account.toString() + "\n");
			} else if(account instanceof Account) {
				accountList.append("   입출금계좌     "+account.toString() + "\n");
			}
		}
		
	}
	
//	계좌 타입을 선택했을때 입력 금지 설정
	public void selectAccountType(AccountType accountType) {
		switch (accountType) {
		case GENERAL_ACCOUNT:
			borrowMoneyTF.setEnabled(false);
			inputMoneyTF.setEnabled(true);
			passwdTF.setEnabled(true);
			printReset();
			break;
		case ALL_ACCOUNT:
			borrowMoneyTF.setEnabled(false);
			inputMoneyTF.setEnabled(false);
			passwdTF.setEnabled(false);
			printReset();
			break;
		case MINUS_ACCOUNT:
			borrowMoneyTF.setEnabled(true); 
			inputMoneyTF.setEnabled(true);
			passwdTF.setEnabled(true);
			printReset();
			break;
		}
		
	}
	
//	계좌 선택시 입력창 초기화 해주는 메소드
	private void printReset() {
		accountNumTF.setText("조회 시에 입력해주세요");
		accountOwnerTF.setText("");
		borrowMoneyTF.setText("");
		inputMoneyTF.setText("");
		passwdTF.setText("");
	}
	
	private void printHeader() {
		accountList.setText("");
		accountList.append("--------------------------------------------------------------------\n");
		accountList.append("     계좌종류   계좌번호   예금주    비밀번호       잔액           대출금액\n");
		accountList.append("====================================================================\n");
	}
	
//	계좌 삭제 기능
	public void removeAccount() {
		String accountNum = accountNumTF.getText();
		boolean removeOk;
		
		if (accountNum != null) {
			removeOk = repository.removeAccout(accountNum);
			if (removeOk) {
				JOptionPane.showMessageDialog(this, "정상 삭제 처리되었습니다");
			} else {
				JOptionPane.showMessageDialog(this, "계좌번호를 확인해주시기 바랍니다");
				printReset();
			}
		} 
		printReset();
		allList();
	}
	
//	계좌번호로 조회 기능
	public void seachAccount() {
		String accountNum = accountNumTF.getText();
		Account seachAccount = repository.searchAccount(accountNum);
		
		printHeader();
		if (seachAccount != null && Validator.isNumber(accountNum)) {
			if (seachAccount instanceof MinusAccount) {
				accountList.append("마이너스계좌     "+seachAccount+"\n");
				printReset();
			}
			else {
				accountList.append("   입출금계좌     "+seachAccount+"\n");
				printReset();
			}
				JOptionPane.showMessageDialog(this, "검색이 완료되었습니다");
			} else {
				JOptionPane.showMessageDialog(this, "계좌번호를 확인해주시기 바랍니다");
				printReset();
			}
		}
	
//	예금주명으로 조회기능
	public void seachOwner() {
		String accountOwner = accountOwnerTF.getText();
		List<Account> list = repository.searchAccountByOwner(accountOwner);
		printHeader();
		if (accountOwner != null && Validator.hasText(accountOwner) && Validator.isName(accountOwner)) {
		for (Account account : list) {
			if (account instanceof MinusAccount) {
				accountList.append("마이너스계좌     "+account+"\n");
				printReset();
			}
			else {
				accountList.append("   입출금계좌     "+account+"\n");
				printReset();
			}
		}
			JOptionPane.showMessageDialog(this, "검색된 계좌의 수는: " +list.size()+"개 입니다");
		} else {
			JOptionPane.showMessageDialog(this, "조회되지 않는 이름입니다");
		}
	}
//	 입출금 계좌 등록
	public void addAccount() {
		
		String accountOwner = accountOwnerTF.getText();
		int password =Integer.parseInt(passwdTF.getText());
		long inputMoney = Long.parseLong(inputMoneyTF.getText());
		
		String selectedItem = accountType.getSelectedItem();
		
		if(selectedItem.equals(AccountType.GENERAL_ACCOUNT.getName())) {
			try {
				account = new Account(accountOwner, password, inputMoney);
			} catch (NotBalanceException e) {
				e.printStackTrace();
			}
		} else if(selectedItem.equals(AccountType.MINUS_ACCOUNT.getName())){
			long borrowMoney = Long.parseLong(borrowMoneyTF.getText());
			try {
				account = new MinusAccount(accountOwner, password, inputMoney, borrowMoney);
			} catch (NotBalanceException e) {
				e.printStackTrace();
			}
		}
		repository.addAccount(account);
		JOptionPane.showMessageDialog(this, "정상 등록 처리되었습니다");
		printReset();
		allList();
	}
}
