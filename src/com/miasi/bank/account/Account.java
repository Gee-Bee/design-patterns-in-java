package com.miasi.bank.account;

public interface Account {

	/**
	 * @return Account number
	 */
	String number();

	/**
	 * @return Account owner
	 */
	String owner();

	/** 
	 * @return Account balance
	 */
	int balance();

	/**
	 * Display account history
	 */
	void displayHistory();

	/**
	 * Deposit given amount
	 * @param amount
	 * @return true
	 */
	boolean deposit(int amount);

	/**
	 * Withdraw given amount
	 * @param amount
	 * @return true - success, false - failure
	 */
	boolean withdraw(int amount);

	/**
	 * @return Due interest
	 */
	int interest();

}