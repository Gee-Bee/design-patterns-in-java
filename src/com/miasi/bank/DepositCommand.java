package com.miasi.bank;

public class DepositCommand implements Command {
	private Account account;
	private int amount;
	
	public DepositCommand(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		account.__addToBalance(amount);
	}
	
	@Override
	public boolean success() {
		return true;
	}

}
