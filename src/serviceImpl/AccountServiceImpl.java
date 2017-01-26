package serviceImpl;

import java.util.Calendar;

import constants.Account;
import domain.AccountBean;
import service.AccountService;
import util.RandomGen;

/**
@FILE  : BankServiceImpl.java
@DATE  : 2017. 1. 24.
@AUTHOR: J.John Park
@STORY	Logic(Business Logic)

 */
public class AccountServiceImpl implements AccountService {
	// 사용하고 나서도 계속 유지되는 패턴 <- 연관관계(Association Relationships)
	AccountBean[] list;  
	
	// has a
	public AccountServiceImpl() {
		list = new AccountBean[10000];
	}
	
	@Override
	public AccountBean createAccount(String uid, String accountType) {
		AccountBean account = new AccountBean(); // 사용하고 나서 없어지는 패턴 <- 의존관계(Dependency Relationships)
		account.setAccountNo(String.valueOf(RandomGen.getRandomNum(999999, 100000)));
		account.setCreateDate(Calendar.getInstance().get(Calendar.YEAR) + "년 "
				+ Calendar.getInstance().get(Calendar.MONTH) + 1 + "월 "
				+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "일");
		account.setUid(uid);
		account.setAccountType(accountType);
		account.setMoney("0");
		list[0] = account;
		return account;
	}
	
	@Override
	public boolean checkMoney(int money) {
		return money>=0;
	}

	@Override
	public String deposit(int money) {
		if(checkMoney(money)) {
			list[0].setMoney(list[0].getMoney() + money);
			return money + Account.DEPOSIT_SUCCESS;
		} else {
			return Account.DEPOSIT_FAIL;
		}
	}

	@Override
	public String withdraw(int money) {
		if(checkMoney(Integer.parseInt(list[0].getMoney()) - money)) {
			list[0].setMoney(String.valueOf(Integer.parseInt(list[0].getMoney()) - money));
			return Account.WITHDRAW_SUCCESS;
		} else {
			return Account.WITHDRAW_FAIL;
		}
	}
}
