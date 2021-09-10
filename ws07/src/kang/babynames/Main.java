package kang.babynames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static List<String> lines = new ArrayList<>();
	public static List<String> boys = new ArrayList<>();
	public static List<String> girls = new ArrayList<>();
	public static List<String> both = new ArrayList<>();

	public static void main(String[] args) {
		getInput();
		checkNames();
		showResult();
	}

	public static void getInput() {
		Scanner scan = new Scanner(System.in);
		String filename = "";
		int year = 0;
		try {
			while (year < 2009 || year > 2018) {
				System.out.print("Enter a year for baby name ranking: ");
				year = scan.nextInt();
				filename = String.format("babynamesranking%d.txt", year);
			}
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
	}
	
	public static void checkNames() {
		for (String line : lines) {
			String[] str = line.split("\t");
			boys.add(str[1].trim());
			girls.add(str[3].trim());
		}

		for (String boy : boys) {
			for (String girl : girls) {
				if (boy.equals(girl)) {
					both.add(boy);
				}
			}
		}
	}

	public static void showResult() {
		Collections.sort(both, (b1, b2) -> b1.compareTo(b2));
		System.out.println(both.size() + " names used for both genders");
		System.out.print("They are ");
		for (String name : both) {
			System.out.print(name + " ");
		}
	}

}
