package com.miasi.bank;

public abstract class BankingProduct implements ElementReportable {

	/**
	 * @return Account number
	 */
	public abstract String number();

	/**
	 * @return Account owner
	 */
	public abstract String owner();

	/**
	 * Display account history
	 */
	public abstract void displayHistory();
	
	public abstract boolean accept(Report report);

}