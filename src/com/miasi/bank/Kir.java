package com.miasi.bank;

import java.util.HashMap;
import java.util.Map;

public class Kir {
	private Map<String, Bank> banks;
	private boolean sessionOpened;
	
	public Kir(Map<String, Bank> banks) {
		this.banks = banks;
	}
	public Kir() {
		this(new HashMap<String, Bank>());
	}
	
	public void openSession() {
		sessionOpened = true;
	}
	
	public boolean closeSession() {
		if(!sessionOpened) return false;
		sessionOpened = false;
		return true;
	}
}
