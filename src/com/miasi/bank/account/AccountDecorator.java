package com.miasi.bank.account;

public abstract class AccountDecorator implements Account {

	protected Account account;
	
	public AccountDecorator(Account account) {
		this.account = account;
	}

	@Override
	public String number() {
		return account.number();
	}

	@Override
	public String owner() {
		return account.owner();
	}

	@Override
	public int balance() {
		return account.balance();
	}

	@Override
	public void displayHistory() {
		account.displayHistory();
	}

	@Override
	public boolean deposit(int amount) {
		return account.deposit(amount);
	}

	@Override
	public boolean withdraw(int amount) {
		return account.withdraw(amount);
	}

	@Override
	public int interest() {
		return account.interest();
	}

}
