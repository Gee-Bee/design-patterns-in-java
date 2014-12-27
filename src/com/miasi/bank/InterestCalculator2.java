package com.miasi.bank;

public class InterestCalculator2 extends InterestCalculator {

	@Override
	public int calculate(int balance) {
		int interest = 0;
		
		if (balance < 5000)
			interest = (int) 0.009 * balance;
		else
			interest = 100 + (int) 0.01 * (balance - 5000);
		
//		history.add("Due interest " + interest);
		
		return interest;
	}

}
