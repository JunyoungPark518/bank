package serviceImpl;

import domain.MemberBean;
import service.AdminService;
import java.util.*;
public class AdminServiceImpl implements AdminService {
	private Map<String, MemberBean> map;
	
	public AdminServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	@Override
	public void register(MemberBean member) {
		map.put(member.getUid(), member);
	}

	@Override
	public MemberBean findById(String id) {
//		return map.containsKey(id) ? map.get(id) : null; // containsKey 알아둘 것!
		return map.get(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		for(MemberBean m : memberList()) {
			if(name.equals(m.getName())) {
				list.add(m);
			}
		}
		return list;
	}

	@Override
	public List<MemberBean> memberList() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public void update(MemberBean member) {
		if(findById(member.getUid())!=null) {
			MemberBean temp = findById(member.getUid());
			temp.setName(!member.getName().equals("") ? member.getName() : temp.getName());
			temp.setPassword(!member.getPassword().equals("") ? member.getPassword() : temp.getPassword());
			temp.setEmail(!member.getEmail().equals("") ? member.getEmail() : temp.getEmail());
			temp.setPhone(!member.getPhone().equals("") ? member.getPhone() : temp.getPhone());
			temp.setProfileImg(!member.getProfileImg().equals("") ? member.getProfileImg() : temp.getProfileImg());
			temp.setRank(!member.getRank().equals("") ? member.getRank() : temp.getRank());
			map.put(member.getUid(), temp);
		}
	}

	@Override
	public void remove(String id) {
		map.remove(id);
	}

	@Override
	public List<String> keyList() {
		List<String> list = new ArrayList<String>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()) {
			list.add(e.getKey());
		}
		return list;
	}

	@Override
	public Map<String, MemberBean> findMapByName(String name) {
		Map<String, MemberBean> temp = new HashMap<String, MemberBean>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				temp.put(e.getKey(), e.getValue());
			}
		}
		return null;
	}
}
