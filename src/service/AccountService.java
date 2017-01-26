package service;

import domain.AccountBean;

public interface AccountService {
	public AccountBean createAccount(String uid, String accountType);
	public boolean checkMoney(int money);
	public String deposit(int money);
	public String withdraw(int money);
}
