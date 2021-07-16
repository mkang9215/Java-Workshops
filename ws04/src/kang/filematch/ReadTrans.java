package kang.filematch;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

public class ReadTrans {
	private static ObjectInputStream input;

	public static void main(String[] args) throws Exception {		
		openFile();
		readRecords();
		closeFile();
	}
	
	public static void openFile() {
		try { 
			input = new ObjectInputStream(Files.newInputStream(Paths.get("trans.txt")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}
	
	public static void readRecords() {
		System.out.printf("%-10s%-10s%n", "Account", "Amount");
		try {
			while (true) { // loop until there is an EOFException
				TransactionRecord tran = (TransactionRecord) input.readObject();
				System.out.printf("%-10d%-10.2f%n", tran.getAccNum(), tran.getAmount());
			}
		} catch (EOFException endOfFileException) {
			System.out.printf("");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
	}
	
	public static Vector<TransactionRecord> readTransRecords() {

		Vector<TransactionRecord> trans = new Vector<>();
		TransactionRecord tran = null;
		try {
			while (true) { // loop until there is an EOFException
				tran = (TransactionRecord) input.readObject();
				trans.add(tran);
			}
		} catch (EOFException endOfFileException) {
			System.out.printf("");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
		return trans;
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
