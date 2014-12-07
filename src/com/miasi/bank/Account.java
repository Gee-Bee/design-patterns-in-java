package com.miasi.bank;

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
	 * @return Account debitLimit
	 */
	int debitLimit();

	/**
	 * Set debitLimit
	 * @param debit
	 */
	void setDebitLimit(int debit);

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