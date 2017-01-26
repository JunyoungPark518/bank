package service;

import domain.MemberBean;

public interface AdminService {
	/*
	 * CREATE: INSERT
	 */
	public void register(MemberBean member);
	/*
	 * READ: SELECT
	 */
	public MemberBean findById(String id);
	public MemberBean[] findByName(String name);
	public int countByName();
	public MemberBean[] list();
	public int count();
	/*
	 * UPDATE: UPDATE
	 */
	public void changeRank(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void remove(MemberBean member);
}
