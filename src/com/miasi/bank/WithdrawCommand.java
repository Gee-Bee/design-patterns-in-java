package com.miasi.bank;

public class WithdrawCommand implements Command {
	private Account account;
	private int amount;
	private boolean success;
	
	public WithdrawCommand(Account account, int amount) {
		this.account = account;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		if (account.balance() + account.debitLimit() >= amount) {
			account.__substractFromBalance(amount);
			success = true;
		} else {
			success = false;
		}
	}
	
	@Override
	public boolean success() {
		return success;
	}

}
