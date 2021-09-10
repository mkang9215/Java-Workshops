package kang.prime;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static int num;
	public static Set<Integer> factors = new HashSet<Integer>();

	public static void main(String args[]) {
		getInput();
		getFactors();
		showResult();
	}

	public static void getInput() {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			try {
				System.out.print("Enter a number: ");
				num = scan.nextInt();
				done = true;
			} catch (InputMismatchException e) {
				System.out.print("Invalid input, ");
				scan.next();
			}
		}
		scan.close();
	}

	public static void getFactors() {
		int temp = num;
		for (int i = 2; i <= temp; i++) {
			while (temp % i == 0) {
				factors.add(i);
				temp /= i;
			}
		}
	}

	public static void showResult() {
		if (factors.contains(num))
			System.out.println(num + " is a prime number");
		else
			System.out.println("prime factors are " + factors);
	}
}