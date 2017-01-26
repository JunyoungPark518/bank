package serviceImpl;

import service.MemberService;

public class MemberServiceImpl implements MemberService {
	@Override
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
