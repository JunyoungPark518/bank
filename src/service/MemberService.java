package service;

import domain.MemberBean;

public interface MemberService {
	/*
	 * CREATE: INSERT
	 */
	public void join(MemberBean member);
	/*
	 * READ: SELECT
	 */
	public MemberBean findById(String id);
	public boolean login(MemberBean member);
	/*
	 * UPDATE: UPDATE
	 */
	public void change(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void remove(MemberBean member);
}
