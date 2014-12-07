package com.miasi.bank.account;

import java.lang.reflect.Field;

public class DebitAccountDecorator extends AccountDecorator {
	private int debit;
	private int debitLimit;

	public DebitAccountDecorator(Account account, int debitLimit) {
		super(account);
		this.debitLimit = debitLimit > 100 ? debitLimit : 100;
	}
	
	@Override
	public int balance() {
		return super.balance() - debit;
	}

	@Override
	public boolean deposit(int amount) {
		if (debit > 0) {
			if (amount > debit) {
				super.deposit(amount - debit);
				debit = 0;
			} else {
				debit -= amount;
			}
			return true;
		} else {
			return super.deposit(amount);
		}
	}
	
	@Override
	public boolean withdraw(int amount) {
		if(amount <= this.balance() + debitLimit) {	// withdrawal possible
			int currentSuperBalance = super.balance();
			if (amount <= currentSuperBalance) {	// withdraw without debit
				return super.withdraw(amount);
			} else {								// withdraw with debit
				super.withdraw(currentSuperBalance);
				debit += amount - currentSuperBalance;
				return true;
			}
		} else {
			return false;
		}
	}
	
	
}
