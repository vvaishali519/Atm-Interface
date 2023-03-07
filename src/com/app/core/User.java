package com.app.core;

public class User {
		
	private String custId;
	private String custPass;
	private Account account;
	
	public User(String custId, String custPass,Account account) {
		super();
		this.custId = custId;
		this.custPass = custPass;
		this.account = account;
	}

	public String getCustId() {
		return custId;
	}
	
	public String getCustPass() {
		return custPass;
	}
	
	public Account getAccount() {
		return account;
	}

	@Override
	public String toString() {
		return "User [custId=" + custId + ", custPass=" + custPass + "]";
	}
	
	
	
}
