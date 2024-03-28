package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DefineNewCategoryController {
	@FXML TextField categoryName;
	
	@FXML
	public void showHomePage(ActionEvent event) {
		try {
			// Load the new page FXML file
	        Parent defineNewCategoryPage = FXMLLoader.load(getClass().getClassLoader().getResource("view/Main.fxml"));
	        // Get the current stage (window) from the event that triggered the method call
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        // Set the scene with the new page
	        stage.setScene(new Scene(defineNewCategoryPage));
	        // Optional: Set the title of the new window (stage)
	        stage.setTitle("Home");
	        // Show the new scene
	        stage.show();
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	@FXML
    private void handleSaveButtonClick() {
        // Check if the text field is empty
        if (categoryName.getText().trim().isEmpty()) {
            // Text field is empty, show the alert
        	// Display error message if the text field is empty
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please enter a category name.");
			alert.showAndWait();
        } else {
            // Save function goes here....
			// Display a message to indicate successful saving
			Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
			successAlert.setTitle("Information");
			successAlert.setHeaderText(null);
			successAlert.setContentText("Category name \"" + categoryName.getText() + "\" has been saved!");
			successAlert.showAndWait();
			categoryName.clear(); // Clear the text from the TextField
        }
    }

}
