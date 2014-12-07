package com.miasi.bank.account;

import java.lang.reflect.Field;

import junit.framework.TestCase;

public class DebitAccountTest extends TestCase {
	
	Account account;

	protected void setUp() throws Exception {
		super.setUp();
		Account baseAccount = new BaseAccount("111", "Jan", "Kowalski");
		account = new DebitAccountDecorator(baseAccount, 200);
	}
	
	public void testDepositGtDebit() throws Exception {
		setDebit(200);
		account.deposit(300);
		assertEquals(0, getDebit());
		assertEquals(100, account.balance());
	}
	
	public void testDepositLtDebit() throws Exception {
		setDebit(200);
		account.deposit(50);
		assertEquals(150, getDebit());
		assertEquals(-150, account.balance());
	}

	public void testWithdrawalWithoutDebit() throws Exception {
		account.deposit(300);
		account.withdraw(200);
		assertEquals(100, account.balance());
		assertEquals(0, getDebit());
	}
	
	public void testWithdrawalWithDebit() throws Exception {
		account.deposit(300);
		account.withdraw(400);
		assertEquals(-100, account.balance());
		assertEquals(100, getDebit());
	}
	
	private void setDebit(int amount) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = DebitAccountDecorator.class.getDeclaredField("debit");
		field.setAccessible(true);
		field.set(account, amount);
	}
	
	private int getDebit() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = DebitAccountDecorator.class.getDeclaredField("debit");
		field.setAccessible(true);
		return (int) field.get(account);
	}

}
