package com.miasi.bank;

import java.util.List;
import java.util.ArrayList;

public class Account {
	private String number;
	private String firstName, lastName;
	private int balance;
	private int debitLimit;
	private List history = new ArrayList();
	private InterestCalculator interestCalculator;
	
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
		this.interestCalculator = new InterestCalculator1();
	}
	
	/**
	 * @return Account number
	 */
	public String number() {
		return number;
	}
	
	/**
	 * @return Account owner
	 */
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

	/**
	 * Display account history
	 */
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
		if (interestCalculator != null)
			return interestCalculator.calculate(balance);
		else
			throw new NullPointerException("No interest calculator assigned");
	}
	
	public void setInterestCalculator(InterestCalculator ic) {
		this.interestCalculator = ic;
	}
}
