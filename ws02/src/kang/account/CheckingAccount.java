package kang.account;

public class CheckingAccount extends Account {
	private double fee;
	
	public CheckingAccount() {
	}

	public CheckingAccount(double balance, double fee) {
		super(balance);
		this.fee = fee;
	}
	
	@Override
	public void credit(double balance) {
		super.credit(balance);
		this.balance -= fee;
	}
	
	@Override
	public void debit(double balance) {
		if(this.balance - balance - fee >= 0) {
			super.debit(balance);
			this.balance -= fee;
		} else {
			System.err.println("Debit amount exceeded account balance.");
		}
	}	
}
