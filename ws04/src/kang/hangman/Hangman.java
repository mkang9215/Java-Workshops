package kang.hangman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Hangman {
	public static void main(String[] args) throws Exception {
		play();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a new word to be added in the memory>");
		String newWord = scan.next();
		FileWriter fw = new FileWriter("hangman.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(newWord + "\n");
		bw.close();
		boolean done = false;
		while (!done) {
			System.out.print("Do you want to guess another word? Enter y or n>");
			String yesNo = scan.next();
			switch (yesNo) {
			case "y":
			case "Y":
				play();
				break;
			case "n":
			case "N":
				System.out.println("Thank you for playing the game. Bye!");
				done = true;
				break;
			default:
				System.out.print("Do you want to guess another word? Enter y or n>");
			}
		}
		scan.close();
	}
	
	public static void play() throws Exception {

		FileReader fr = new FileReader("hangman.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		Vector<String> words = new Vector<>();
		while ((line = br.readLine()) != null) {
			words.add(line);
		}
		br.close();

		Random r = new Random();
		String word = words.get(r.nextInt(words.size()));
		String hidden = "";
		for (int i = 0; i < word.length(); i++) {
			hidden += "*";
		}
		Scanner scan = new Scanner(System.in);

		Vector<String> chars = new Vector<>();
		int miss = 0;

		while (hidden.indexOf("*") != -1) {
			System.out.print("(Guess) Enter a letter in word " + hidden + ">");
			String ch = scan.next();
			boolean already = false;
			for (String cha : chars) {
				if (cha.equals(ch)) {
					already = true;
				}
			}
			if (already && word.indexOf(ch) != -1) {
				System.out.println(ch + " is already in the word");
			} else if (already) {
				System.out.println("You have already tried " + ch + ", try a new letter");
			} else {
				chars.add(ch);
				if (word.indexOf(ch) != -1) {
					String copy = hidden;
					hidden = "";
					for (int i = 0; i < word.length(); i++) {
						if (word.charAt(i) == ch.charAt(0)) {
							hidden += word.charAt(i);
						} else {
							hidden += copy.charAt(i);
						}
					}
				} else {
					miss++;
					System.out.println(ch + " is not in the word");
				}

			}
		}
		System.out.println("The word is " + word + ". You missed " + miss + " time");
	}
}