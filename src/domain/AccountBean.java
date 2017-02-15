package domain;

import java.io.Serializable;

// ObjetStream을 쓰기 위해 Serializable
public class AccountBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uid, accountType, createDate, money, accountNo;
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return String.format("%s\n [%s]\n %s\n %s\n ￦:%s", 
				accountNo, accountType, uid, createDate, money);
	}
}
