package kang.set;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		IntegerSet A = new IntegerSet();
		IntegerSet B = new IntegerSet();
		IntegerSet C= new IntegerSet();
		
		boolean done = false;
		int num;
		Scanner input = new Scanner(System.in);
		System.out.println("Input Set A");
		while(!done) {
			System.out.print("Enter number (-1 to end): ");
			num = input.nextInt();
			if(num >= 0 && num <= 100) {				
				A.insertElement(num);
			} else if(num == -1) {
				done = true;
			}
		}
		
		System.out.println("Set A contains elements");
		System.out.println(toString(A.arr));
		
		done = false;
		System.out.println("Input Set B");
		while(!done) {
			System.out.print("Enter number (-1 to end): ");
			num = input.nextInt();
			if(num >= 0 && num <= 100) {
				B.insertElement(num);
			} else if(num == -1) {
				done = true;
			}
		}
		

		System.out.println("Set B contains elements");
		System.out.println(toString(B.arr));
		System.out.println("Set C contains elements");
		System.out.println(toString(C.arr));
		
		System.out.println("Union of Set A and Set B contains elements");
		System.out.println(toString(union(A.arr, B.arr)));
		
		System.out.println("Intersection of Set A and Set B contains elements");
		System.out.println(toString(intersection(A.arr, B.arr)));
		
		if(isEqualTo(A.arr, B.arr)) {
			System.out.println("Set A and Set B are equal");
		} else {
			System.out.println("Set A is not equal to Set B");
		}
		System.out.println();
		System.out.println("Inserting 77 into set A");
		A.insertElement(77);
		System.out.println("Set A contains elements");
		System.out.println(toString(A.arr));
		
		System.out.println("Deleting 77 from set A");
		A.deleteElement(77);
		System.out.println("Set A contains elements");
		System.out.println(toString(A.arr));
		
	}	

	public static boolean[] union(boolean[] a, boolean[] b) {
		boolean[] union = new boolean[101]; 
		for (int i = 0; i < a.length; i++) {
			if(a[i] || b[i]) {
				union[i] = true;
			}
		}
		return union;
	}
	
	public static boolean[] intersection(boolean[] a, boolean[] b) {
		boolean[] intersection = new boolean[101]; 
		for (int i = 0; i < a.length; i++) {
			if(a[i] && b[i]) {
				intersection[i] = true;
			}
		}
		return intersection;
	}
	
	public static String toString(boolean[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			if(a[i] == true) {
				s += i + " ";
			}
		}
		if(s.equals("")) {
			s = "---";
		}
		return "{" + s + "}";
	}	

	public static boolean isEqualTo(boolean[] a, boolean[] b) {
		boolean equal = true;
		for (int i = 0; i < a.length; i++) {
			if(a[i] != b [i]) {
				equal = false;
			}
		}
		return equal;
	}	

}
