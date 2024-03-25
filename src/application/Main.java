package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Main extends Application {
	// Constant variables for stage title
	private final static String firstStageTitle = "Home Page";
	private final static String secondStageTitle = "Define new category";

	@Override
	public void start(Stage primaryStage) {
		try {
			// Create a button for defining a new category
			Button defCatBtn = new Button();
			defCatBtn.setText("Define New Category");
			defCatBtn.setFont(Font.font("Arial", FontWeight.BOLD, 24));
			defCatBtn.setTextFill(Color.rgb(212, 180, 131));

			// Create a heading text for the home page
			Label titleLabel = new Label("My Asset Tracker");
			// set fontsize, fontstyle, fontweight, and color for the heading text
			titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
			titleLabel.setTextFill(Color.rgb(212, 180, 131));

			// Define the main layout pane and set its properties
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-color: #E4DFDA;");
			root.setPadding(new Insets(20));
			root.setTop(titleLabel);
			BorderPane.setAlignment(titleLabel, Pos.CENTER);
			root.setCenter(defCatBtn);
			BorderPane.setAlignment(defCatBtn, Pos.CENTER);

			// Create a scene using the layout pane.
			Scene scene = new Scene(root, 400, 400);

			// Define New Category Button behavior
			defCatBtn.setOnAction(e -> {
				// Define a layout pane for the define new category page and set its properties.
				// Used VBox layout pane to position the textinput and the save button
				// vertically
				VBox root2 = new VBox();
				root2.setPadding(new Insets(20, 20, 20, 20));
				root2.setStyle("-fx-background-color: #E4DFDA;");
				root2.setSpacing(10);

				// Create a heading text for the define new category page
				Label label = new Label("Define new category");
				// set fontsize, fontstyle, fontweight, and color for the heading text
				label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
				label.setTextFill(Color.rgb(212, 180, 131));
				// Define another layout pane and nest it inside the VBox layout pane to
				// horizontally center the the heading text in the define new category page
				BorderPane borderPane = new BorderPane();
				borderPane.setCenter(label);

				// Create a text field for entering the category name and set its properties
				TextField textField = new TextField();
				textField.setPromptText("Enter category name");
				textField.setPrefWidth(200);
				textField.setPrefHeight(50);
				textField.setStyle("-fx-border-color: #3498db; -fx-border-width: 2;");
				textField.setFont(Font.font(16));
				// Add scale transitions to text field
				ScaleTransition textboxScaleTransitionEnter = new ScaleTransition(Duration.millis(200), textField);
				textboxScaleTransitionEnter.setToX(1.01); // Increase size by 10%
				textboxScaleTransitionEnter.setToY(1.01);
				ScaleTransition textboxScaleTransitionExit = new ScaleTransition(Duration.millis(200), textField);
				textboxScaleTransitionExit.setToX(1); // Return to original size
				textboxScaleTransitionExit.setToY(1);
				textField.setOnMouseEntered(event -> textboxScaleTransitionEnter.playFromStart());
				textField.setOnMouseExited(event -> textboxScaleTransitionExit.playFromStart());

				// Create a save button in the define new category page and set its properties
				Button saveBtn = new Button("Save");
				saveBtn.setStyle("-fx-background-color: #48A9A6; -fx-text-fill: black; -fx-border-radius: 5;");
				saveBtn.setPrefHeight(30);
				saveBtn.setPrefWidth(80);

				// Add scale transitions to the button
				ScaleTransition btnScaleTransitionEnter = new ScaleTransition(Duration.millis(200), saveBtn);
				btnScaleTransitionEnter.setToX(1.05); // Increase size by 10%
				btnScaleTransitionEnter.setToY(1.05);
				ScaleTransition btnScaleTransitionExit = new ScaleTransition(Duration.millis(200), saveBtn);
				btnScaleTransitionExit.setToX(1); // Return to original size
				btnScaleTransitionExit.setToY(1);
				saveBtn.setOnMouseEntered(event -> btnScaleTransitionEnter.playFromStart());
				saveBtn.setOnMouseExited(event -> btnScaleTransitionExit.playFromStart());

				// Event handler for the Save button
				saveBtn.setOnAction(event -> {
					// Define New Category Page
					String categoryName = textField.getText().trim(); // Save the category name

					if (categoryName.isEmpty()) {
						// Display error message if the text field is empty
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Please enter a category name.");
						alert.showAndWait();
					} else {
						textField.clear(); // Clear the text from the TextField

						// Display a message to indicate successful saving
						Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
						successAlert.setTitle("Information");
						successAlert.setHeaderText(null);
						successAlert.setContentText("Category name \"" + categoryName + "\" has been saved!");
						successAlert.showAndWait();
					}
				});

				// Application secondary page: Define New Category Page
				root2.getChildren().addAll(borderPane, textField, saveBtn);
				Scene scene2 = new Scene(root2, 400, 400);
				primaryStage.setScene(scene2);
				primaryStage.setTitle(secondStageTitle);
				primaryStage.show();
			});

			// Application initial stage: Home Page
			primaryStage.setScene(scene);
			primaryStage.setTitle(firstStageTitle);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
