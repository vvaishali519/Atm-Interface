package com.app.core;

public class Account {
	
	private double balance;
	private String accType;
	
	public Account(double balance,String accType) {
		super();
		this.balance = balance;
		this.accType=accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
