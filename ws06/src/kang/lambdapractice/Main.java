package kang.lambdapractice;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static final ArrayProcessor maximum = (values) -> {
		double max = values[0];
		for (double val : values) {
			if (val > max) {
				max = val;
			}
		}
		return max;
	};

	public static final ArrayProcessor minimum = (values) -> {
		double min = values[0];
		for (double val : values) {
			if (val < min) {
				min = val;
			}
		}
		return min;
	};

	public static final ArrayProcessor sum = (values) -> {
		double sum = 0;
		for (double val : values) {
			sum += val;
		}
		return sum;
	};

	public static final ArrayProcessor average = (values) -> {
		return (sum.apply(values)) / values.length;
	};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Vector<String> inputs = new Vector<>();

		String input;
		boolean done = false;
		while (!done) {
			System.out.print("Enter a number(enter x to exit): ");
			while (!scan.hasNextDouble() && !scan.hasNext("x")) {
			    System.out.print("Enter a number or x: ");
			    scan.nextLine();
			}
			input = scan.nextLine();
			if(input.equals("x")) {
				done = true;
				break;
			}
			inputs.add(input);
		}

		double[] values = new double[inputs.size()];
		for(int i = 0 ; i < inputs.size() ; i++){
		    values[i] = Double.parseDouble(inputs.get(i));
		}
		System.out.println("The maximum value is " + maximum.apply(values));
		System.out.println("The minimum value is " + minimum.apply(values));
		System.out.println("The sum of the values is " + sum.apply(values));
		System.out.printf("The average of the values is %.2f%n", average.apply(values));

		System.out.print("Which value to count: ");
		double val;
		while (!scan.hasNextDouble()) {
		    System.out.print("Enter a number value to count: ");
		    scan.nextLine();
		}
		val = scan.nextDouble();
		System.out.println(val + " has " + (int)counter(val).apply(values) + " counts.");
		scan.close();
	}
	
	public static ArrayProcessor counter(double value) {
		ArrayProcessor ap = (values) -> {
			int count = 0;
			for (double val : values) {
				if (val == value) {
					count++;
				}
			}
			return count;
		};
		return ap;
	}
}
