package kang.craps;

import java.util.Random;

public class Craps {
	public static void main(String[] args) {
		int sum = getSum();
		
		if(sum == 2 || sum == 3 || sum == 12) {
			System.out.println("Craps, Better Luck Next Time, You lose");
		} else if(sum == 7 || sum == 11) {
			System.out.println("Congratulations, You win");
		} else {
			int point = sum;
			System.out.println("Point is (established) set to " + point);
			
			boolean done = false;
			while(!done) {
				sum = getSum();
				if(sum == 7) {
					System.out.println("Craps, Better Luck Next Time, You lose");
					done = true;
				} else if(sum == point) {
					System.out.println("Congratulations, You win");
					done = true;
				}
			}
		}		
	}

	public static int roll() {	    
	    return new Random().nextInt(6) + 1;
	}
	
	public static int getSum() {
		int roll1 = roll();
		int roll2 = roll();
		int sum = roll1 + roll2;
		System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + sum);
	    return sum;
	}
	
	
}
