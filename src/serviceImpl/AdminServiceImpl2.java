package serviceImpl;

import domain.MemberBean;
import service.AdminService2;

public class AdminServiceImpl2 implements AdminService2 {
	private MemberBean[] arr;
	private int count;
	private int countByName;
	public AdminServiceImpl2() {
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
		arr[count++] = member;
	}

	
	@Override
	public MemberBean findById(String id) {
		MemberBean mb = new MemberBean();
		for(int i=0; i<count; i++) {
			if(id.equals(arr[i].getUid())) {
				mb = arr[i];
				break;
			}
		}
		return mb;
	}

	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] mbarr = new MemberBean[countByName(name)];
		int index = 0;
		for(int i=0; i<count; i++) {
			if(name.equals(arr[i].getName())) {
				mbarr[index] = arr[i];
				index++;
			}
		}
		return mbarr;
	}

	@Override
	public int countByName(String name) {
		countByName = 0;
		for(int i=0; i<count; i++) {
			if(name.equals(arr[i].getName())) {
				countByName++;
			}
		}
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
		for(int i=0; i<count; i++) {
			if(member.getUid().equals(arr[i].getUid())) {
				arr[i].setRank(member.getRank());
				break;
			}
		}
	}

	@Override
	public void remove(String id) {
		for(int i=0; i<count; i++) {
			if(id.equals(arr[i].getUid())) {
				arr[i] = arr[count];
				arr[count] = null;
				break;
			}
		}
		count--;
	}
	
	@Override
	public boolean exist(String keyword) {
		boolean exist = false;
		for(int i=0; i<count; i++) {
			if(keyword.equals(arr[i].getUid()) || keyword.equals(arr[i].getName())) {
				exist = true;
				break;
			} 
		}
		return exist;
	}
}
