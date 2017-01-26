package serviceImpl;

import domain.MemberBean;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	private MemberBean member;
	private MemberBean[] arr;
	private int count;
	private int countByName;
	public AdminServiceImpl() {
		member = new MemberBean();
		count = 0;
		arr = new MemberBean[count];
	}
	// 회원 정보를 입력한 후 배열에 저장하기
	@Override
	public void register(MemberBean member) {
		if(count == arr.length) {
			MemberBean[] temp = new MemberBean[count+10];
			System.arraycopy(arr, 0, temp, 0, count);
			arr = temp;
		}
		arr[count] = member;
		count++;
	}

	
	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByName() {
		// TODO Auto-generated method stub
		return countByName;
	}

	// 전체목록 출력
	@Override
	public MemberBean[] list() {
		return arr;
	}

	@Override
	public int count() {
		/* SELECT COUNT(*) FROM MemberBean */
		return count;
	}

	@Override
	public void changeRank(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
}
