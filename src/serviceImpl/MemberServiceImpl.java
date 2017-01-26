package serviceImpl;

import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	@Override
	public void join(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(MemberBean member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void change(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	
	public String calcGender(String ssn) {
		String gender = "";
		char ch = ssn.charAt(7);
		if(ch=='1'||ch=='3') {
			gender = "남자";
		} else if(ch=='2'||ch=='4') {
			gender = "여자";
		} else if(ch=='5'||ch=='6') {
			gender = "외국인";
		} else {
			gender = "알 수 없음";
		}
		return gender;
	}
}
