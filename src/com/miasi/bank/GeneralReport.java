package com.miasi.bank;

public class GeneralReport implements Report {

	@Override
	public boolean visit(BankingProduct bankingProduct) {
		System.out.println("General Report generated for " + bankingProduct);
		return true;
	}

}
