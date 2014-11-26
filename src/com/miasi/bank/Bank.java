package com.miasi.bank;

import java.util.HashMap;

public class Bank {
	private HashMap accounts = new HashMap();

	/**
	 * Create account and add to accounts hash.
	 * @param number
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Account createAccount(String number, String firstName, String lastName) {
		Account account = new Account(number, firstName, lastName);
		accounts.put(number, account);
		return account;
	}

	/**
	 * Search accounts
	 * @param number
	 * @return account if found, null otherwise
	 */	
	public Account search(String number) {
		return (Account) accounts.get(number);
	}
	
	/**
	 * Money transfer from account with number1 to account with number2
	 * @param number1
	 * @param number2
	 * @param amount
	 * @return 0 - success, -1 - failure
	 */
	public int transfer(String number1, String number2, int amount) {
		Account account1 = search(number1);
		Account account2 = search(number2);
		
		return transfer(account1, account2, amount);
	}
	
	/**
	 * Money transfer from account1 to account2
	 * @param account1
	 * @param account2
	 * @param amount
	 * @return 0 - success, -1 - failure
	 */
	public int transfer(Account account1, Account account2, int amount) {
		account1.withdrawal(amount);
		account2.deposit(amount);

		return 0;
	}
}