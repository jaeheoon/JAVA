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

import ezen.ams.app.AMSui;
import ezen.ams.domain.Account;
import ezen.ams.domain.AccountType;
import ezen.ams.domain.MinusAccount;
import ezen.ams.exception.NotBalanceException;

public class AMSFrame extends Frame {
	Button seachB, delteB, checkB, printInfoB, accountSetB;
	Choice accountType;
	TextField accountNumTF, accountOwnerTF, passwdTF, inputMoneyTF, borrowMoneyTF;
	TextArea accountList;
	Label accountTypeL, accountNumL, accountOwnerL, passwdL, inputMoneyL, borrowMoneyL, accontListL, typeL;
	
	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints con = new GridBagConstraints();
	
	Account account = null;
	
	public AMSFrame() {
		this("No-Title");
	}
	
	public AMSFrame(String title) {
		super(title);
		
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
		
//		accountType.add("전체 계좌");
//		accountType.add("입출금계좌");
//		accountType.add("마이너스계좌");
		
		AccountType[] accountTypes = AccountType.values();
		for (AccountType accountT : accountTypes) {
			accountType.add(accountT.getName());
		}
		
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
//		컴포넌트를 GridBagConstraints에 설정
		grid.setConstraints(c, con);
//		프레임에 컴포넌트 배치
		add(c);
	}
	
	public void addEventListner() {
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == accountSetB) {
					addAccount();
				} else if(eventSource == printInfoB) {
					allList();
				}
			}
		}
		ActionListener actionListener = new ActionHandler();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				//윈도우 x키 눌렀을때 닫히는 메소드
				exit();
			}
			
			@Override
	        public void windowOpened(WindowEvent e) {
	            System.out.println("opeeeeeen");
	        }
		});
		
		
// 계좌 등록
		accountSetB.addActionListener(actionListener);
// 계좌 선택
		accountType.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(accountType.getSelectedItem().equals("입출금계좌")) {
					selectAccountType(AccountType.GENERAL_ACCOUNT);					
				}					
			}
			
		}
	});

// 전체계좌 조회
		printInfoB.addActionListener(actionListener);
				
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void allList() {
		System.out.println("open");
		accountList.setText("");
		printHeader();
		List<Account> list = AMSui.repository.getAccounts();
		for (Account account : list) {
			accountList.append(account.toString() + "\n");
		}
	}
	
//	계좌 타입을 선택했을때
	public void selectAccountType(AccountType accountType) {
		switch (accountType) {
		case GENERAL_ACCOUNT:
			borrowMoneyTF.setEnabled(false); break;
		case ALL_ACCOUNT:
			borrowMoneyTF.setEnabled(false); break;
		case MINUS_ACCOUNT:
			borrowMoneyTF.setEnabled(true); break;
		}
		
	}
	
	private void printHeader() {
		accountList.append("---------------------------------------------\n");
		accountList.append("계좌번호 예금주 비밀번호  잔액 대출금액\n");
		accountList.append("=============================================\n");
	}
	
	public void addAccount() {
		
//		계좌번호는 자동 생성하기 때문에 입력 받지 않아도 됨
//		String accountNum = accNumTF.getText();
//		if(!Validator.hasText(accountNum)) {
//			accNumTF.setText("계좌번호 입력혀라...");
//		}
		
		// 편의상 정상 입력되었다 가정
		String accountOwner = accountOwnerTF.getText();
		int password =Integer.parseInt(passwdTF.getText());
		long inputMoney = Long.parseLong(inputMoneyTF.getText());
		
		String selectedItem = accountList.getSelectedText();
		// 입출금 계좌 등록
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
		
		AMSui.repository.addAccount(account);
//		System.out.println("ADD Compliete!!!");
		JOptionPane.showMessageDialog(this, "정상 등록 처리되었습니다.");
	}
}
