package com.miasi.bank;

import junit.framework.TestCase;

public class InterestCalculator2Test extends TestCase {
	
	InterestCalculator interestCalculator;
	
	protected void setUp() throws Exception {
		super.setUp();
		interestCalculator = new InterestCalculator2();
	}
	
	public void testInterestforBalanceLt5000() throws Exception {
		assertEquals(0, interestCalculator.calculate(4000));
	}
	
	public void testInterestForBalanceGte5000() throws Exception {
		assertEquals(100, interestCalculator.calculate(100000));
	}

}
