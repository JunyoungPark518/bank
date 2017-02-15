package service;

import domain.MemberBean;

public interface AdminService2 {
	/*
	 * CREATE: INSERT
	 */
	public void register(MemberBean member);
	/*
	 * READ: SELECT
	 */
	public MemberBean findById(String id);
	public MemberBean[] findByName(String name);
	public int countByName(String name);
	public MemberBean[] list();
	public int count();
	/*
	 * UPDATE: UPDATE
	 */
	public void changeRank(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void remove(String id);
	/*
	 * UTIL(Validation)
	 */
	public boolean exist(String keyword);
}
