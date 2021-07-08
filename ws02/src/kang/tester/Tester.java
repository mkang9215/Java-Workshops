package kang.tester;

import kang.account.Account;
import kang.account.CheckingAccount;
import kang.account.SavingsAccount;

public class Tester {
	public static void main(String[] args) {
		Account A = new Account(-100);
		System.out.println("A balance: " + A.getBalance());
		System.out.println("----------------");

		Account B = new Account(1000);
		System.out.println("B balance: " + B.getBalance());
		System.out.println("----------------");

		CheckingAccount C = new CheckingAccount(2000, 5);
		System.out.println("C balance: " + C.getBalance());	
		C.credit(500);
		System.out.println("C balance: " + C.getBalance());	
		C.debit(3000);
		System.out.println("C balance: " + C.getBalance());	
		C.debit(1000);
		System.out.println("C balance: " + C.getBalance());	
		System.out.println("----------------");

		SavingsAccount S = new SavingsAccount(2000, 0.1);
		System.out.println("S balance: " + S.getBalance());	
		System.out.println("S interest: " + S.calculateInterest());			
		S.credit(500);
		System.out.println("S balance: " + S.getBalance());	
		S.debit(3000);
		System.out.println("S balance: " + S.getBalance());	
		S.debit(1000);
		System.out.println("S balance: " + S.getBalance());	
		System.out.println("S interest: " + S.calculateInterest());	
		
	}
}
