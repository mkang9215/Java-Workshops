package kang.filematch;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLog {
	private static ObjectInputStream input;

	public static void main(String[] args) throws Exception {
		openFileNew();
		readRecords();
		closeFile();
	}

	public static void openFileNew() {
		try { 
			input = new ObjectInputStream(Files.newInputStream(Paths.get("log.txt")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	public static void readRecords() {
		System.out.println("Unmatched transaction record for account number");
		try {
			while (true) { // loop until there is an EOFException
				Integer i = (Integer) input.readObject();
				System.out.printf("%-10d%n", i);
			}
		} catch (EOFException endOfFileException) {
			System.out.printf("%nNo more records%n");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
	}

	public static void closeFile() {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}
}
