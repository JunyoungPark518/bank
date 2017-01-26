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
	public MemberBean find(String id);
	/*
	 * UPDATE: UPDATE
	 */
	public void change(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void remove(String id, String pw);
}
