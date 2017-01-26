package controller;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MemberBean;
import service.AccountService;
import serviceImpl.AccountServiceImpl;

public class CustomerController {
	public void start() {
		MemberBean member = null;
		AccountBean account = null;
		AccountService service = new AccountServiceImpl(); // 선언 및 초기화를 항상 같이 한다.
		String temp = "";
		while(true) {
			switch(inputInt("1.회원등록\n"
					+ "2.통장개설\n"
					+ "3.입금\n"
					+ "4.출금\n"
					+ "5.조회\n"
					+ "6.해지\n"
					+ "0.종료")) {
			case 0:
				return;
			case 1: // 회원등록
				member = new MemberBean();
				member.setName(input("이름을 입력하세요."));
				while(true) {
					temp = input("주민번호(ex:900101-1)를 입력하세요.");
					char ch = temp.charAt(7);
					if(ch == '7' || ch == '0' || ch == '8' || ch == '9') {
						show("주민번호가 올바르지 않습니다.");
					} else {
						break;
					}
				}
				member.setSsn(temp);
				member.setUid(input("아이디를 입력하세요."));
				show(member.getName() + "님 회원등록이 완료되었습니다.");
				break;
			case 2: // 통장개설
				while(true) {
					if(input("아이디를 입력하세요.").equals(member.getUid())) {
						account.setAccountType(input("예금 타입은 어떻게 되나요?"));
						account = service.create(member);
						show(account.toString());
						break;
					} else {
						show("아이디를 잘못 입력하셨습니다.");
					}
				}
				break;
			case 3: // 입금
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					show(service.deposit(inputInt("얼마를 입금하시겠습니까?")));
				} else {
					notCase(account);
				}
				break;
			case 4: // 출금
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					int withdraw = inputInt("얼마를 출금하시겠습니까?");
					show(service.withdraw(withdraw));
				} else {
					notCase(account);
				}
				break;
			case 5: // 조회
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					show(String.format("%s님의 현재 잔액은 %d원입니다.", member.getName(), account.getMoney()));
				} else {
					notCase(account);
				}
				break;
			case 6: // 해지
				if(input("아이디를 입력하세요.").equals(member.getUid()) && account != null) {
					account = (input("정말 해지하실 건가요?\n"
							+ "해지하시려면 '해지'를 입력하세요.").equals("해지")) ? null : account;
					if(account==null) {
						show("해지가 완료되었습니다.");
					}
				} else {
					notCase(account);
				}
				break;
			}
		}
	}
	
	// 사용 편의를 위한 추가 생성 메서드
	private String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
	
	private void show(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	private int inputInt(String str) {
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
	
	private void notCase(AccountBean a) {
		if(a == null) {
			show("통장을 먼저 개설하세요.");
		} else {
			show("입력한 아이디와 일치하는 아이디가 없습니다.");
		}
	}
}
