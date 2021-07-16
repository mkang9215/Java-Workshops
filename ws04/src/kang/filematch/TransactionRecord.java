package kang.filematch;

import java.io.Serializable;

public class TransactionRecord implements Serializable {
	private int accNum;
	private double amount;
	
	public TransactionRecord() {
		this(0, 0.0);
	}
	
	public TransactionRecord(int accNum, double amount) {
		super();
		this.accNum = accNum;
		this.amount = amount;
	}
	
	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
