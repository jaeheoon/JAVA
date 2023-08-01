package ezen.ams.view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
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

import ezen.ams.app.AMS;
import ezen.ams.domain.Account;
import ezen.ams.domain.AccountType;
import ezen.ams.domain.MinusAccount;
import ezen.ams.util.Validator;

@SuppressWarnings("serial")
public class AmsFrame extends Frame {
	Button checkB, deleteB, searchB, newRegB, allCheckB;
	Label acctypeL, accNumL, AccOwnerL, pwL, loanL, AccListL, depositL, wonL;
	TextField accNumTF, AccOwnerTF, pwTF, loanTF, depositTF;
	TextArea bottomTA;
	Choice choice;
	
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints con = new GridBagConstraints();

	public AmsFrame() {
		this("무제");
	}

	public AmsFrame(String title) {
		super(title);
//		setTitle(title);
//		label 8개
		acctypeL = new Label("계좌종류");
		accNumL = new Label("계좌번호");
		AccOwnerL = new Label("예금주명");
		pwL = new Label("비밀번호");
		loanL = new Label("대출금액");
		AccListL = new Label("계좌목록");
		depositL = new Label("입금금액");
		wonL = new Label("(단위 : 원)");
//		choice 3항목
		choice = new Choice();
//		choice.add("전체");
//		choice.add("입출금계좌");
//		choice.add("마이너스계좌");
		AccountType[] accountTypes = AccountType.values();
		for (AccountType accountType : accountTypes) {
			choice.add(accountType.getName());
		}
		
		
//		button 5개
		checkB = new Button("조회");
		deleteB = new Button("삭제");
		searchB = new Button("검색");
		newRegB = new Button("신규등록");
		allCheckB = new Button("전체조회");
//		ta 1개 및 tf 5개
		bottomTA = new TextArea();
		accNumTF = new TextField(20);
		AccOwnerTF = new TextField(20);
		pwTF = new TextField(20);
		loanTF = new TextField(20);
		depositTF = new TextField(8);
	}

	/**
	 * GridBagLayout 적용 컴포넌트 add 메소드
	 * @param component = 삽입 할 컴포넌트
	 * @param gridx = 컴포넌트 x 좌표
	 * @param gridy = 컴포넌트 y 좌표
	 * @param gridwidth = 격자 가로값
	 * @param gridheight = 격자 세로값
	 */
	public void addCon(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
		con.insets = new Insets(10,10,10,10);
//		con.fill = GridBagConstraints.BOTH;
		con.gridx = gridx;
		con.gridy = gridy;
		con.gridwidth = gridwidth;
		con.gridheight = gridheight;
		con.weighty = 0.0;
		con.weightx = 0.0;
		gridbag.setConstraints(component, con);
		add(component);
		con.anchor = GridBagConstraints.CENTER;
	}
	
	public void init() {
		setLayout(gridbag);
		addCon(acctypeL, 0, 0, 1, 1);
		addCon(choice, 1, 0, 1, 1);
		
		addCon(accNumL, 0, 1, 1, 1);
		addCon(accNumTF, 1, 1, 1, 1);
		addCon(checkB, 2, 1, 1, 1);
		addCon(deleteB, 3, 1, 1, 1);
		
		addCon(AccOwnerL, 0, 2, 1, 1);
		addCon(AccOwnerTF, 1, 2, 1, 1);
		addCon(searchB, 2, 2, 1, 1);
		
		addCon(pwL, 0, 3, 1, 1);
		addCon(pwTF, 1, 3, 1, 1);
		addCon(depositL, 2, 3, 1, 1);
		addCon(depositTF, 3, 3, 3, 1);
		
		addCon(loanL, 0, 4, 1, 1);
		addCon(loanTF, 1, 4, 1, 1);
		addCon(newRegB, 2, 4, 1, 1);
		addCon(allCheckB, 3, 4, 1, 1);
		
		addCon(AccListL, 0, 5, 1, 1);
		addCon(wonL, 3, 5, 1, 1);
		
		addCon(bottomTA, 0, 6, 5, 2);
	}
	
	private void printHeader() {
		bottomTA.append("---------------------------------------------\n");
		bottomTA.append("계좌번호 예금주 비밀번호  잔액 대출금액\n");
		bottomTA.append("=============================================\n");
	}
	
	public void allList() {
		bottomTA.setText("");
		printHeader();
		List<Account> list = AMS.repository.getAccounts();
		for (Account account : list) {
			bottomTA.append(account.toString() + "\n");
		}
	}
	
	public void selectAccountType(AccountType accountType) {
		switch (accountType) {
		case GENERAL_ACCOUNT:
			loanTF.setEnabled(false); break;
		}
		
	}
	
	public void addAccount() {
		Account account = null;
		
//		계좌번호는 자동 생성하기 때문에 입력 받지 않아도 됨
//		String accountNum = accNumTF.getText();
//		if(!Validator.hasText(accountNum)) {
//			accNumTF.setText("계좌번호 입력혀라...");
//		}
		
		// 편의상 정상 입력되었다 가정
		String accountOwner = AccOwnerTF.getText();
		int password =Integer.parseInt(pwTF.getText());
		long inputMoney = Long.parseLong(depositTF.getText());
		
		String selectedItem = choice.getSelectedItem();
		// 입출금 계좌 등록
		if(selectedItem.equals(AccountType.GENERAL_ACCOUNT.getName())) {
			account = new Account(accountOwner, password, inputMoney);
		} else if(selectedItem.equals(AccountType.MINUS_ACCONUT.getName())){
			long loanMoney = Long.parseLong(loanTF.getText());
			account = new MinusAccount(accountOwner, password, inputMoney, loanMoney);
		}
		
		AMS.repository.addAccount(account);
//		System.out.println("ADD Compliete!!!");
		JOptionPane.showMessageDialog(this, "정상 등록 처리되었습니다.");
	}
	
	/**
	 * 종료 메소드
	 */
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void addEventListner() {
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == newRegB) {
					addAccount();
				} else if(eventSource == allCheckB) {
					allList();
				}			
			}
		}
		ActionListener actionListener = new ActionHandler();
		
		
		// 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		// 창이 열릴때
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				allList();
			}
		});
		
		// 계좌 등록
		newRegB.addActionListener(actionListener);
		// 계좌 선택
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(choice.getSelectedItem().equals("입출금계좌")) {
						selectAccountType(AccountType.GENERAL_ACCOUNT);					
					}					
				}
				
			}
		});
		
		// 전체계좌 조회
		allCheckB.addActionListener(actionListener);
		
		
	}
	
	
	/**
	 * 편의 상 아래에 메인메소드에서 구현
	 * @param args
	 */
	public static void main(String[] args) {
		AmsFrame frame = new AmsFrame("EZEN_BANK_AMS");
		frame.init();
		frame.pack();
		frame.setResizable(false);
		frame.addEventListner();
		frame.setVisible(true);
	}
}








