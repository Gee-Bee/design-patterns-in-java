package com.miasi.bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

	Bank bank = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		bank = new Bank("11111111", "Bank A");
	}
	
	public void testName() throws Exception {
		assertEquals("Bank A", bank.name());
	}
	
	public void testNumber() throws Exception {
		assertEquals("11111111", bank.number());
	}
	
	public void testInvalidNumber() throws Exception {
		try {
			bank = new Bank("Bank B", "1234567a");
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException success) {}
	}

	public void testCreateAccount() {
		Account account = bank.createAccount("00111111112222222222222222", "John", "Doe");
		assertEquals("00111111112222222222222222", account.number());
		
		account = bank.search("00111111112222222222222222");
		assertNotNull(account);
		assertEquals("00111111112222222222222222", account.number());
	}

	public void testSearch() {
		Account account = bank.createAccount("00111111112222222222222222", "John", "Doe");
		
		for (int i : new int[]{1,2}) {
			account = bank.search("00111111112222222222222222");
			assertEquals("00111111112222222222222222", account.number());
		}
		
	}

	public void testTransferStringStringInt() {
		Account account1 = bank.createAccount("00111111112222222222222222", "John", "Doe");
		Account account2 = bank.createAccount("00111111113333333333333333", "Jane", "Roe");
		account1.deposit(500);
		boolean transferSuccess = bank.transfer("00111111112222222222222222", "00111111113333333333333333", 200);
//		assertTrue(transferSuccess);
		assertEquals(300, account1.balance());
//		assertEquals(200, account2.balance());
	}

	public void testTransferInternal() {
		Account account1 = bank.createAccount("00111111112222222222222222", "John", "Doe");
		Account account2 = bank.createAccount("00111111113333333333333333", "Jane", "Roe");
		account1.deposit(500);
		boolean transferSuccess = bank.transferInternal(account1, account2, 200);
		assertTrue(transferSuccess);
		assertEquals(300, account1.balance());
		assertEquals(200, account2.balance());
	}
	
	public void testTransferFailure() {
		Account account1 = bank.createAccount("00111111112222222222222222", "John", "Doe");
		Account account2 = bank.createAccount("00111111113333333333333333", "Jane", "Roe");
		account1.deposit(500);
		boolean transferSuccess = bank.transferInternal(account1, account2, 600);
		assertFalse(transferSuccess);
		assertEquals(500, account1.balance());
		assertEquals(0, account2.balance());
	}

}
