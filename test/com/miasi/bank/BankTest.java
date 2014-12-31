package com.miasi.bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

	Bank bank = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		bank = new Bank();
	}

	public void testCreateAccount() {
		BankingProduct account = bank.createAccount("111", "John", "Doe");
		assertEquals("111", account.number());
		
		account = bank.search("111");
		assertNotNull(account);
		assertEquals("111", account.number());
	}

	public void testSearch() {
		BankingProduct account = bank.createAccount("111", "John", "Doe");
		
		for (int i : new int[]{1,2}) {
			account = bank.search("111");
			assertEquals("111", account.number());
		}
		
	}

	public void testTransferStringStringInt() {
		Account account1 = bank.createAccount("111", "John", "Doe");
		Account account2 = bank.createAccount("112", "Jane", "Roe");
		account1.deposit(500);
		boolean transferSuccess = bank.transfer("111", "112", 200);
		assertTrue(transferSuccess);
		assertEquals(300, account1.balance());
		assertEquals(200, account2.balance());
	}

	public void testTransferAccountAccountInt() {
		Account account1 = bank.createAccount("111", "John", "Doe");
		Account account2 = bank.createAccount("112", "Jane", "Roe");
		account1.deposit(500);
		boolean transferSuccess = bank.transfer(account1, account2, 200);
		assertTrue(transferSuccess);
		assertEquals(300, account1.balance());
		assertEquals(200, account2.balance());
	}
	
	public void testTransferFailure() {
		Account account1 = bank.createAccount("111", "John", "Doe");
		Account account2 = bank.createAccount("112", "Jane", "Roe");
		account1.deposit(500);
		boolean transferSuccess = bank.transfer(account1, account2, 600);
		assertFalse(transferSuccess);
		assertEquals(500, account1.balance());
		assertEquals(0, account2.balance());
	}
	
	public void testDoingReport() throws Exception {
		GeneralReport report = new GeneralReport();
		bank.createAccount("111", "Jan", "Kowalski");
		bank.createAccount("112", "Janek", "Kowalski");
		bank.doReport(report);
	}

}
