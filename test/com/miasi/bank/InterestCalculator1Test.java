package com.miasi.bank;

import junit.framework.TestCase;

public class InterestCalculator1Test extends TestCase {
	
	InterestCalculator interestCalculator;
	
	protected void setUp() throws Exception {
		super.setUp();
		interestCalculator = new InterestCalculator1();
	}
	
	public void testInterestforBalanceLt10000() throws Exception {
		assertEquals(0, interestCalculator.calculate(8000));
	}
	
	public void testInterestForBalaceLt50000() throws Exception {
		assertEquals(100, interestCalculator.calculate(20000));
	}
	
	public void testInterestForBalanceGte50000() throws Exception {
		assertEquals(900, interestCalculator.calculate(100000));
	}

}
