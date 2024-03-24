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

public class Home extends Application {
	private final static String title =  "Define new category";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Home Page
			Button defCatBtn = new Button();
			defCatBtn.setText("Define New Category");
			defCatBtn.setFont(Font.font("Arial", FontWeight.BOLD, 24));
			defCatBtn.setTextFill(Color.rgb(212,  180, 131));
			
			BorderPane root = new BorderPane();
			root.setTop(defCatBtn);
			BorderPane.setAlignment(defCatBtn, Pos.CENTER_RIGHT);
			
			Scene scene = new Scene(root, 400, 400);

			// Define New Category Button behavior
			defCatBtn.setOnAction(e -> {
				VBox root2 = new VBox();
				root2.setPadding(new Insets(20,20,20,20));
				root2.setStyle("-fx-background-color: #E4DFDA;");
				root2.setSpacing(10);
				
				Label label = new Label("Define new category");
				label.setFont(Font.font("Arial",FontWeight.BOLD, 24));
				label.setTextFill(Color.rgb(212, 180, 131));
				BorderPane borderPane = new BorderPane();
		        borderPane.setCenter(label);
		        
		        TextField textField = new TextField();
				textField.setPromptText("Enter category name");
				textField.setPrefWidth(200);
		        textField.setPrefHeight(50);
		        textField.setStyle("-fx-border-color: #3498db; -fx-border-width: 2;");
		        textField.setFont(Font.font(16));
		        ScaleTransition textboxScaleTransitionEnter = new ScaleTransition(Duration.millis(200), textField);
		        textboxScaleTransitionEnter.setToX(1.01); // Increase size by 10%
		        textboxScaleTransitionEnter.setToY(1.01);
		        ScaleTransition textboxScaleTransitionExit = new ScaleTransition(Duration.millis(200), textField);
		        textboxScaleTransitionExit.setToX(1); // Return to original size
		        textboxScaleTransitionExit.setToY(1);
		        textField.setOnMouseEntered(event -> textboxScaleTransitionEnter.playFromStart());
		        textField.setOnMouseExited(event -> textboxScaleTransitionExit.playFromStart());
		        
		        Button saveBtn = new Button("Save");
				saveBtn.setStyle("-fx-background-color: #48A9A6; -fx-text-fill: black; -fx-border-radius: 5;");
				saveBtn.setPrefHeight(30);
				saveBtn.setPrefWidth(80);
				ScaleTransition btnScaleTransitionEnter = new ScaleTransition(Duration.millis(200), saveBtn);
		        btnScaleTransitionEnter.setToX(1.05); // Increase size by 10%
		        btnScaleTransitionEnter.setToY(1.05);
		        ScaleTransition btnScaleTransitionExit = new ScaleTransition(Duration.millis(200), saveBtn);
		        btnScaleTransitionExit.setToX(1); // Return to original size
		        btnScaleTransitionExit.setToY(1);
		        saveBtn.setOnMouseEntered(event -> btnScaleTransitionEnter.playFromStart());
		        saveBtn.setOnMouseExited(event -> btnScaleTransitionExit.playFromStart());
		        
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
		        root2.getChildren().addAll(borderPane,textField,saveBtn);
				Scene scene2 = new Scene(root2,400,400);
				primaryStage.setScene(scene2);
				primaryStage.setTitle(title);
				primaryStage.show();
			});
			
			// Application initial stage: Home Page
			primaryStage.setScene(scene);
			primaryStage.setTitle("Home Page");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
