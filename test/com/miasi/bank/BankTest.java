package com.miasi.bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

	Bank bank = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		bank = new Bank();
	}

	public void testCreateAccount() {
		Account account = bank.createAccount("111", "John", "Doe");
		assertEquals("111", account.number());
		
		account = bank.search("111");
		assertNotNull(account);
		assertEquals("111", account.number());
	}

	public void testSearch() {
		fail("Not yet implemented");
	}

	public void testTransferStringStringInt() {
		fail("Not yet implemented");
	}

	public void testTransferAccountAccountIntt() {
		fail("Not yet implemented");
	}

}
