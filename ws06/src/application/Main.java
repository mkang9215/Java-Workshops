package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	TextField yearField = new TextField();
	TextField genderField = new TextField();
	TextField nameField = new TextField();
	Text resultText = new Text("");

	public static void main(String[] args) {
		launch(args);
	}	

	@Override
	public void start(Stage stage) throws Exception {

		// query
		GridPane queryPane = new GridPane();
		queryPane.setHgap(10);
		queryPane.setVgap(10);
		queryPane.setPadding(new Insets(25, 25, 25, 25));

		queryPane.add(new Label("Enter the Year:"), 0, 0);
		queryPane.add(yearField, 1, 0);

		queryPane.add(new Label("Enter the Gender:"), 0, 1);
		queryPane.add(genderField, 1, 1);

		queryPane.add(new Label("Enter the Name:"), 0, 2);
		queryPane.add(nameField, 1, 2);

		Button submitQueryBtn = new Button("Submit Query");
		queryPane.add(submitQueryBtn, 0, 3);

		Button exitBtn = new Button("Exit");
		queryPane.add(exitBtn, 1, 3);

		stage.setTitle("Search Name Ranking Application");
		Scene queryScene = new Scene(queryPane);
		stage.setScene(queryScene);
		stage.show();

		// result
		GridPane resultPane = new GridPane();
		resultPane.setHgap(10);
		resultPane.setVgap(10);
		resultPane.setPadding(new Insets(25, 25, 25, 25));

		resultPane.add(resultText, 0, 0);
		resultPane.add(new Text("Do you want to search for another name?"), 0, 1);

		Button yesBtn = new Button("Yes");
		resultPane.add(yesBtn, 0, 2);
		Button noBtn = new Button("No");
		resultPane.add(noBtn, 1, 2);

		Scene resultScene = new Scene(resultPane);

		// buttons in lambda
		submitQueryBtn.setOnAction(e -> {
			getResult();
			stage.setScene(resultScene);
		});

		exitBtn.setOnAction(e -> {
			System.exit(0);
		});

		yesBtn.setOnAction(e -> {
			stage.setScene(queryScene);
		});

		noBtn.setOnAction(e -> {
			System.exit(0);
		});
	}

	private void getResult() {
		String result = "";
		int year = Integer.parseInt(yearField.getText());
		String filename = String.format("babynamesranking%d.txt", year);

		String gender = genderField.getText().toUpperCase();
		if (gender.equals("M")) {
			gender = "Boy";
		} else if (gender.equals("F")) {
			gender = "Girl";
		} else {
			gender = "Undefined";
		}

		String name = nameField.getText();
		String rank = "";
		boolean found = false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null && !found) {
				String[] str = line.split("\t");
				if (gender.equals("Boy") && str[1].trim().toLowerCase().equals(name.toLowerCase())) {
					rank = str[0];
					found = true;
				} else if (gender.equals("Girl") && str[3].trim().toLowerCase().equals(name.toLowerCase())) {
					rank = str[0];
					found = true;
				}
			}
		} catch (FileNotFoundException fe) {
			year = -1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (year == -1) {
			result = "Enter correct year from 2009 to 2018";
		} else if (gender.equals("Undefined")) {
			result = "Type M or F for gender";
		} else if (rank.equals("")) {
			result = String.format("%s name %s is not found in %d year", gender, name, year);
		} else {
			result = String.format("%s name %s is ranked #%s in %d year", gender, name, rank, year);
		}
		yearField.setText("");
		genderField.setText("");
		nameField.setText("");
		resultText.setText(result);
	}

}
