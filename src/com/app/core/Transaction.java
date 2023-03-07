package com.app.core;

import java.util.Date;

public class Transaction {
	
	private int tId;
	private Double transAmt;
	private Date transDate;
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Double getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(Double transAmt) {
		this.transAmt = transAmt;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", transAmt=" + transAmt + ", transDate=" + transDate + "]";
	}
	
}
