package com.app.core;

import java.io.IOException;

public interface IBankTransaction {
	
	public boolean validateUser(String custId,String password,User user) throws IOException,Exception;
	public void transferMoney(User user,double amt,String accNo) throws IOException,Exception;
	public void withdrawMoney(User user,double amt) throws IOException,Exception;
	public void depositMoney(User user,double amt) throws IOException,Exception;
	public void pinChange(User user,String oldPin) throws Exception;
	public void balanceInquiry() throws IOException,Exception;
	public void transactionHistory();
}
