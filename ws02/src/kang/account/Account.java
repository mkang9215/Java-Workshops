package kang.account;

public class Account {
	protected double balance;
	
	public Account() {		
	}
	
	public Account(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		} else {
			System.err.println("Error in initial balance.");
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void credit(double balance) {
		this.balance += balance;
	}
	
	public void debit(double balance) {
		if(this.balance - balance >= 0) {
			this.balance -= balance;
		} else {
			System.err.println("Debit amount exceeded account balance.");
		}
	}	
}
