package kang.tester;

import java.util.Scanner;

import kang.account.Account;
import kang.account.CheckingAccount;
import kang.account.SavingsAccount;

public class Tester2 {
	public static void main(String[] args) {
		Account[] arr = new Account[3];
		arr[0] = new Account(1000);
		arr[1] = new CheckingAccount(2000, 5);
		arr[2] = new SavingsAccount(2000, 0.1);		

		System.out.println("---Current Balance---");
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Arr[" + i + "] balance is " + arr[i].getBalance());
		}

		Scanner input = new Scanner(System.in);
		boolean done = false;
		double credit;
		double debit;
		int menu;
		for(int i = 0; i < arr.length; i++) {
			System.out.println("-----Arr[" + i + "]-----");
			done = false;
			while(!done) {
				System.out.println("0 Exit, 1 Credit, 2 Debit");
				System.out.print("Enter menu: ");
				menu = input.nextInt();
				if(menu == 1) {
					System.out.print("credit amount to Arr[" + i + "]: ");
					credit = input.nextDouble();
					arr[i].credit(credit);
				} else if(menu == 2) {
					System.out.print("debit amount from Arr[" + i + "]: ");
					debit = input.nextDouble();
					arr[i].debit(debit);
				} else if(menu == 0) {
					done = true;
				} 
			}
		}
		
		System.out.println("---Balance After Processing---");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof SavingsAccount) {
				arr[i].credit(((SavingsAccount)arr[i]).calculateInterest());
			} 
			System.out.println("Arr[" + i + "] balance is " + arr[i].getBalance());
		}

	}
}
