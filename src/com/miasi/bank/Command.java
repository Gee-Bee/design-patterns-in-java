package com.miasi.bank;

public interface Command {
	void execute();
	boolean success();
}
