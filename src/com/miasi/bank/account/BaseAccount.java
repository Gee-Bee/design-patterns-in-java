package com.miasi.bank.account;

import java.util.List;
import java.util.ArrayList;

public class BaseAccount implements Account {
	private String number;
	private String firstName, lastName;
	private int balance;
	private List history = new ArrayList();
	
	/**
	 * Account creation
	 * @param number
	 * @param firstName
	 * @param lastName
	 */
	public BaseAccount(String number, String firstName, String lastName) {
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#number()
	 */
	@Override
	public String number() {
		return number;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#owner()
	 */
	@Override
	public String owner() {
		return firstName + " " + lastName;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#balance()
	 */
	@Override
	public int balance() {
		return balance;
	}

	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#displayHistory()
	 */
	@Override
	public void displayHistory() {
		System.out.println(history);
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#deposit(int)
	 */
	@Override
	public boolean deposit(int amount) {
		balance += amount;
		history.add("Deposit: " + amount + ", balance: " + balance);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#withdraw(int)
	 */
	@Override
	public boolean withdraw(int amount) {
		if(amount <= balance) {
			balance -= amount;
			history.add("Withdrawal: " + amount + ", balance: " + balance);
			return true;
		}
		history.add("Failed withdrawal: " + amount + ", balance: " + balance);
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.Account#interest()
	 */
	@Override
	public int interest() {
		int interest = 0;
		
		if (balance < 10000)
			interest = (int) 0.01 * balance;
		else if (balance < 50000)
			interest = 100 + (int) 0.02 * (balance - 10000);
		else 
			interest =  100 + 800 + (int) 0.03 * (balance - 50000);
		
//		history.add("Due interest " + interest);
		
		return interest;
	}
}
