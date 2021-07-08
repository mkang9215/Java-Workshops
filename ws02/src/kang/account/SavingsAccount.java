package kang.account;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount() {		
	}
	
	public SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
		return balance * interestRate;
	}	

}
