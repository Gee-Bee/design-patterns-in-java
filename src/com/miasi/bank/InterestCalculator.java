package com.miasi.bank;

public abstract class InterestCalculator {
	/**
	 * @return Due interest
	 */
	public abstract int calculate(int balance);
}