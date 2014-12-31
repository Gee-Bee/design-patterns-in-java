package com.miasi.bank;

import java.util.List;
import java.util.ArrayList;

public class Account extends BankingProduct {
	private String number;
	private String firstName, lastName;
	private int balance;
	private int debitLimit;
	private List history = new ArrayList();
	
	/**
	 * Account creation
	 * @param number
	 * @param firstName
	 * @param lastName
	 */
	public Account(String number, String firstName, String lastName) {
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.BankingProduct#number()
	 */
	@Override
	public String number() {
		return number;
	}
	
	/* (non-Javadoc)
	 * @see com.miasi.bank.BankingProduct#owner()
	 */
	@Override
	public String owner() {
		return firstName + " " + lastName;
	}
	
	/** 
	 * @return Account balance
	 */
	public int balance() {
		return balance;
	}
	
	/**
	 * @return Account debitLimit
	 */
	public int debitLimit() {
		return debitLimit;
	}
	
	/**
	 * Set debitLimit
	 * @param debit
	 */
	public void setDebitLimit(int debit) {
		if (debit > 100)
			debitLimit = debit;
	}

	/* (non-Javadoc)
	 * @see com.miasi.bank.BankingProduct#displayHistory()
	 */
	@Override
	public void displayHistory() {
		System.out.println(history);
	}
	
	/**
	 * Deposit given amount
	 * @param amount
	 * @return true
	 */
	public boolean deposit(int amount) {
		balance += amount;
		history.add("Deposit: " + amount + ", balance: " + balance);
		return true;
	}
	
	/**
	 * Withdraw given amount
	 * @param amount
	 * @return true - success, false - failure
	 */
	public boolean withdraw(int amount) {
		if (balance + debitLimit >= amount) {
			balance -= amount;
			history.add("Withdrawal: " + amount + ", balance: " + balance);
			return true;
		}
		history.add("Failed withdrawal: " + amount + ", balance: " + balance);
		return false;
	}
	
	/**
	 * @return Due interest
	 */
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
	
	public boolean accept(Report report) {
		return report.visit(this);
	}
}
