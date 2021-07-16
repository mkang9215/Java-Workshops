package kang.filematch;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteTrans {
	private static ObjectOutputStream output;

	public static void main(String[] args) {
		openFile();
		addRecords();
		closeFile();
	}

	public static void openFile() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("trans.txt")));

		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void addRecords() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ", "Enter account number and amount.",
				"Enter end-of-file indicator to end input.");

		while (scan.hasNext()) {
			try {

				TransactionRecord record = new TransactionRecord(scan.nextInt(), scan.nextDouble());
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
