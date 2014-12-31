package com.miasi.bank;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class AccountTest extends TestCase {
	
	Account account;

	protected void setUp() throws Exception {
		super.setUp();
		account = new Account("00111111112222222222222222", "John", "Doe");
	}

	public void testNumber() throws Exception {
		assertEquals("00111111112222222222222222", account.number());
	}	

	public void testInvalidNumber() throws Exception {
		try {
			account = new Account("1234567a", "John", "Doe");
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException success) {}
	}

	public void testOwner() throws Exception {
		assertEquals("John Doe", account.owner());
	}
	
	public void testBalance() throws Exception {
		assertEquals(0, account.balance());
	}
	
	public void testDebitLimit() throws Exception {
		assertEquals(0, account.debitLimit());
	}
	
	public void testSetTooLowDebitLimit() throws Exception {
		account.setDebitLimit(50);
		assertEquals(0, account.debitLimit());
	}
	
	public void testSetDebitLimit() throws Exception {
		account.setDebitLimit(101);
		assertEquals(101, account.debitLimit());
	}
	
	public void testDeposit() throws Exception {
		boolean success = account.deposit(100);
		assertTrue(success);
		assertEquals(100, account.balance());
	}
	
	public void testWithdrawal() throws Exception {
		account.deposit(400);
		account.setDebitLimit(200);
		boolean success = account.withdraw(600);
		assertTrue(success);
		assertEquals(-200, account.balance());
	}
	
	public void testFailedWithdrawal() throws Exception {
		boolean success = account.withdraw(100);
		assertFalse(success);
		assertEquals(0, account.balance());
	}
	
	public void testDisplayHistory() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut( new PrintStream(baos) );
		account.deposit(100);
		account.withdraw(100);
		account.withdraw(100);
		account.displayHistory();
		System.setOut( new PrintStream(new FileOutputStream(FileDescriptor.out)) );
		assertEquals("[Deposit: 100, balance: 100, Withdrawal: 100, balance: 0, Failed withdrawal: 100, balance: 0]\n", baos.toString());
	}
	
	public void testInterestforBalanceLt10000() throws Exception {
		account.deposit(8000);
		assertEquals((int) 0.01 * account.balance(), account.interest());
	}
	
	public void testInterestForBalaceLt50000() throws Exception {
		account.deposit(20000);
		assertEquals((int) 100 + (int) 0.02 * (account.balance() - 10000), account.interest());
	}
	
	public void testInterestForBalanceGte50000() throws Exception {
		account.deposit(60000);
		assertEquals(100 + 800 + (int) 0.03 * (account.balance() - 50000), account.interest());
	}

}
