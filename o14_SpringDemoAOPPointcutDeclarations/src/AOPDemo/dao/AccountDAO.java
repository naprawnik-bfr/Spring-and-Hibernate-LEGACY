package AOPDemo.dao;

import org.springframework.stereotype.Component;

import AOPDemo.apps.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK - ADDING AN ACCOUNT.");
	}
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + ": DOING MY DB WORK - ADDING AN ACCOUNT WITH ONE PARAMETER.");
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK - ADDING AN ACCOUNT WITH MANY PARAMETER.");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": DOING WORK.");
		
		return false;
	}
}
