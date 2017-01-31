package controller;

import javax.swing.JOptionPane;

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
				String keyword = input("검색하려는 ID?");
				member = service.findById(keyword);
				if(service.exist(keyword)) {
					show("아이디가 존재합니다.");
				} else {
					show("검색하신 아이디가 존재하지 않습니다.");
				}
				break;
			case 3: // 이름검색
				String result = input("검색하려는 이름?");
				if(service.exist(result)) {
					MemberBean[] list = service.findByName(result);
					result = "";
					for(int i=0; i<list.length; i++) {
						result += list[i].toString() + "\n";
					}
					show(result);
				} else {
					show("검색하신 아이디가 존재하지 않습니다.");
				}
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
				member = new MemberBean();
				String[] rank = input("ID, RANK?").split(",");
				if(service.exist(rank[0])) {
					member.setRank(rank[1]);
					service.changeRank(member);
					show("아이디의 등급이 " + rank[1] + "로 변경되었습니다.");
				}
				break;
			case 6: // 삭제
				member = new MemberBean();
				String deletion = input("삭제할 ID를 입력하세요.");
				if(service.exist(deletion)) {
					service.remove(deletion);
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
}
