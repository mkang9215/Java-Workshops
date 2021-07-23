package application;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public TextField firstNameField = new TextField();
	public TextField lastNameField = new TextField();
	public TextField cityField = new TextField();
	public ComboBox<String> provinceField = new ComboBox<String>();
	public TextField postalCodeField = new TextField();

	public Vector<String> lines = new Vector<>();
	public int lineIndex = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		readFromFile();

		GridPane gp = new GridPane();

		gp.getColumnConstraints().add(new ColumnConstraints(70));
		gp.getColumnConstraints().add(new ColumnConstraints(70));
		gp.getColumnConstraints().add(new ColumnConstraints(70));
		gp.getColumnConstraints().add(new ColumnConstraints(70));
		gp.getColumnConstraints().add(new ColumnConstraints(70));
		gp.getColumnConstraints().add(new ColumnConstraints(70));

		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		gp.add(new Label("First Name: "), 0, 0);
		gp.add(firstNameField, 1, 0, 5, 1);

		gp.add(new Label("Last Name: "), 0, 1);
		gp.add(lastNameField, 1, 1, 5, 1);

		gp.add(new Label("City: "), 0, 2);
		gp.add(cityField, 1, 2);

		provinceField.getItems().addAll("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT");
		provinceField.setEditable(true);
		gp.add(new Label("Province: "), 2, 2);
		gp.add(provinceField, 3, 2);

		gp.add(new Label("Postal Code: "), 4, 2);
		gp.add(postalCodeField, 5, 2);

		Button addBtn = new Button("Add");
		gp.add(addBtn, 0, 3);

		Button firstBtn = new Button("First");
		gp.add(firstBtn, 1, 3);

		Button previousBtn = new Button("Previous");
		gp.add(previousBtn, 2, 3);

		Button nextBtn = new Button("Next");
		gp.add(nextBtn, 3, 3);

		Button lastBtn = new Button("Last");
		gp.add(lastBtn, 4, 3);

		Button updateBtn = new Button("Update");
		gp.add(updateBtn, 5, 3);

		showRecord(0);

		firstBtn.setOnAction(e -> {
			showRecord(0);
		});

		nextBtn.setOnAction(e -> showNextRecord());
		previousBtn.setOnAction(e -> showPrevRecord());

		lastBtn.setOnAction(e -> {
			showRecord(lines.size() - 1);
		});

		addBtn.setOnAction(e -> {
			lines.add(String.join(",", getInput()));
			writeToFile();
			System.out.println("Record added");
		});

		updateBtn.setOnAction(e -> {
			lines.set(lineIndex, String.join(",", getInput()));
			writeToFile();
			System.out.println("Record updated");
		});

		Scene scene = new Scene(gp);

		stage.setTitle("Address Book");
		stage.setScene(scene);
		stage.show();

	}

	public void readFromFile() {
		String line;
		try {
			RandomAccessFile file = new RandomAccessFile("addressBook.txt", "r");
			file.seek(0);
			while ((line = file.readLine()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeToFile() {
		try {
			RandomAccessFile file = new RandomAccessFile("addressBook.txt", "rw");
			file.seek(0);
			for (String line : lines) {
				file.write(line.getBytes(StandardCharsets.UTF_8));
				file.write("\n".getBytes(StandardCharsets.UTF_8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showRecord(int index) {
		String[] str = lines.get(index).split(",");

		firstNameField.setText(str[0]);
		lastNameField.setText(str[1]);
		cityField.setText(str[2]);
		provinceField.setValue(str[3]);
		postalCodeField.setText(str[4]);
	}

	public void showNextRecord() {
		if (lineIndex < lines.size() - 1) {
			lineIndex++;
		}
		showRecord(lineIndex);
	}

	public void showPrevRecord() {
		if (lineIndex > 0) {
			lineIndex--;
		}
		showRecord(lineIndex);
	}

	public String[] getInput() {
		if (firstNameField.getText().length() > 35 || lastNameField.getText().length() > 35
				|| cityField.getText().length() > 35 || postalCodeField.getText().length() > 6) {	
			throw new Error("Too long, try again");
		}
		return new String[] { firstNameField.getText(), lastNameField.getText(), cityField.getText(),
				provinceField.getValue(), postalCodeField.getText() };
	}

}
