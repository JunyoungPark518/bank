package controller;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MemberBean;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start() {
		MemberBean member = null;
		AdminService service = new AdminServiceImpl(); // 선언 및 초기화를 항상 같이 한다.
		while(true) {
			MemberBean[] arr = service.list();
			switch(inputInt("1.회원등록\n"
					+ "2.ID검색\n"
					+ "3.이름검색\n"
					+ "4.목록조회\n"
					+ "5.등급조정\n"
					+ "6.삭제\n"
					+ "0.종료")) {
			case 0:
				return;
			case 1: // 회원등록
				member = new MemberBean();
				String[] inputarr = input("ID/이름?").split("/");
				member.setUid(inputarr[0]);
				member.setName(inputarr[1]);
				service.register(member);
				show(String.format("현재 회원수는 %d명입니다.", service.count()));
				break;
			case 2: // ID검색
				break;
			case 3: // 이름검색
				break;
			case 4: // 목록조회
				if(service.count() == 0) {
					show("회원이 존재하지 않습니다.");
				} else {
					String temp = "";
					for(int i=0; i<service.count(); i++) {
						temp += arr[i].toString() + "\n";
					}
					show(temp);
				}
				break;
			case 5: // 등급조정
				break;
			case 6: // 삭제
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
