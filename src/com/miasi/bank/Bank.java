package com.miasi.bank;

import java.util.Map;
import java.util.HashMap;

public class Bank {
	private String name;
	private String number;
	private Map<String,Account> accounts = new HashMap<String, Account>();
	
	public Bank(String number, String name) {
		if(!number.matches("\\d{8}"))
			throw new IllegalArgumentException("Nieprawidłowy numer banku");
		this.number = number;
		this.name = name;
	}
	
	public String name() {
		return name;
	}
	
	public String number() {
		return number;
	}
	
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
	 * @return true - success, false - failure
	 */
	public boolean transfer(String numberFrom, String numberTo, int amount) {
		if(!numberFrom.matches("\\d{26}") || !numberTo.matches("\\d{26}"))
			throw new IllegalArgumentException("Nieprawidłowy numer rachunku");
		if(!this.number.equals(numberFrom.substring(2,10)))
			throw new IllegalArgumentException("Rachunek źródłowy jest w innym banku");
		if(this.number.equals(numberTo.substring(2,11))) {
			Account accountFrom = search(numberFrom);
			Account accountTo = search(numberTo);
			return transferInternal(accountFrom, accountTo, amount);
		} else {
			return true;
		}
	}
	
	/**
	 * Money transfer from account1 to account2
	 * @param account1
	 * @param account2
	 * @param amount
	 * @return true - success, false - failure
	 */
	public boolean transferInternal(Account account1, Account account2, int amount) {
		return account1.withdraw(amount) &&	account2.deposit(amount);
	}
}