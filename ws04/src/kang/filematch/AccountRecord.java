package kang.filematch;

import java.io.Serializable;

public class AccountRecord implements Serializable {
	private int accNum;
	private String fName;
	private String lName;
	private double balance;
	
	public AccountRecord() {
		this(0, "", "", 0.0);
	}

	public AccountRecord(int accNum, String fName, String lName, double balance) {
		super();
		this.accNum = accNum;
		this.fName = fName;
		this.lName = lName;
		this.balance = balance;
	}
	
	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void combine(TransactionRecord tr) {
		if(tr.getAccNum() == this.getAccNum()) {
			setBalance(getBalance() + tr.getAmount());
		}
	}
}
