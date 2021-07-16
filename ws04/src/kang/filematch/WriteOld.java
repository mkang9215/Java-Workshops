package kang.filematch;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteOld {
	private static ObjectOutputStream output;

	public static void main(String[] args) {
		openFile();
		addRecords();
		closeFile();
	}

	public static void openFile() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("oldmast.txt")));

		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void addRecords() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name and balance.",
				"Enter end-of-file indicator to end input.");

		while (scan.hasNext()) {
			try {
				AccountRecord record = new AccountRecord(scan.nextInt(), scan.next(), scan.next(),
						scan.nextDouble());
				output.writeObject(record);
			} catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
				scan.nextLine();
			} catch (IOException ioException) {
				System.err.println("Error writing to file. Terminating.");
				break;
			}
			System.out.print("? ");
		}
	}

	public static void closeFile() {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
}
