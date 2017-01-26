package service;

import domain.AccountBean;
import domain.MemberBean;

public interface AccountService {
	// create
	public AccountBean create(MemberBean member);
	// read one
	public AccountBean findByAccountNo(String accountNo);
	// read some
	public AccountBean[] findByName(String name);
	public int countByName(String name);
	// read all
	public AccountBean[] list();
	public int count();
	// read special 
	public boolean checkMoney(int money);
	// update
	public String deposit(int money);
	public String withdraw(int money);
	// delete
	public void drop(String accountNo);
}
