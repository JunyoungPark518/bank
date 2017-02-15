package service;

import domain.MemberBean;
import java.util.*;

public interface AdminService {
	/*
	 * CREATE: INSERT
	 */
	public void register(MemberBean member);
	/*
	 * READ: SELECT
	 */
	// 전송할 때는 ArrayList를 전송하기 때문에 List<?>로 쓴다
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public Map<String, MemberBean> findMapByName(String name);
	public List<MemberBean> memberList();
	public List<String> keyList();
	public int count();
	/*
	 * UPDATE: UPDATE
	 */
	public void update(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void remove(String id);
}
