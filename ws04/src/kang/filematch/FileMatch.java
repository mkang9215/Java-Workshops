package kang.filematch;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

public class FileMatch {
	private static ObjectInputStream input;
	private static ObjectOutputStream output;

	public static void main(String[] args) throws Exception {
		openFileOld();
		openFileNew();
		combineRecords();
		closeFileIn();
		closeFileOut();
	}

	public static void openFileOld() {
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get("oldmast.txt")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	public static void openFileNew() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("newmast.txt")));

		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void combineRecords() {
		System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
		try {
			while (true) { // loop until there is an EOFException
				AccountRecord record = (AccountRecord) input.readObject();
				ReadTrans.openFile();

				Vector<TransactionRecord> trans = ReadTrans.readTransRecords();
				for (TransactionRecord tran : trans) {
					record.combine(tran);
				}
				ReadTrans.closeFile();

				System.out.printf("%-10d%-12s%-12s%10.2f%n", record.getAccNum(), record.getfName(), record.getlName(),
						record.getBalance());

				output.writeObject(record);
			}
		} catch (EOFException endOfFileException) {
			System.out.printf("%nNo more records%n");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
		}
	}

	public static void closeFileIn() {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}

	public static void closeFileOut() {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
}