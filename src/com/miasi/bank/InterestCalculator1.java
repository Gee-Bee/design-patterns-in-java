package com.miasi.bank;

public class InterestCalculator1 extends InterestCalculator {

	@Override
	public int calculate(int balance) {
		int interest = 0;
		
		if (balance < 10000)
			interest = (int) 0.01 * balance;
		else if (balance < 50000)
			interest = 100 + (int) 0.02 * (balance - 10000);
		else 
			interest =  100 + 800 + (int) 0.03 * (balance - 50000);
		
		return interest;
	}

}
