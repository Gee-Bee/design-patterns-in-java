package com.miasi.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class Bank {
	private Map<String,BankingProduct> bankingProducts = new HashMap<String, BankingProduct>();

	/**
	 * Create account and add to accounts hash.
	 * @param number
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Account createAccount(String number, String firstName, String lastName) {
		Account account = new Account(number, firstName, lastName);
		bankingProducts.put(number, (BankingProduct)account);
		return account;
	}

	/**
	 * Search accounts
	 * @param number
	 * @return account if found, null otherwise
	 */	
	public Account search(String number) {
		return (Account) bankingProducts.get(number);
	}
	
	/**
	 * Money transfer from account with number1 to account with number2
	 * @param number1
	 * @param number2
	 * @param amount
	 * @return true - success, false - failure
	 */
	public boolean transfer(String number1, String number2, int amount) {
		Account account1 = search(number1);
		Account account2 = search(number2);
		
		return transfer(account1, account2, amount);
	}
	
	/**
	 * Money transfer from account1 to account2
	 * @param account1
	 * @param account2
	 * @param amount
	 * @return true - success, false - failure
	 */
	public boolean transfer(Account account1, Account account2, int amount) {
		return account1.withdraw(amount) &&	account2.deposit(amount);
	}
	
	/**
	 * 
	 * @return List of BankingProducts for which raport was generated
	 */
	public List<BankingProduct> doReport(Report report) {
		List<BankingProduct> reportGenerated = new ArrayList<BankingProduct>();
		for (Entry<String, BankingProduct> entry : bankingProducts.entrySet()) {
			BankingProduct bankingProduct = (BankingProduct)entry.getValue();
			if(bankingProduct.accept(report)) {
				reportGenerated.add(bankingProduct);
			}
		}
		return reportGenerated;
	}
}