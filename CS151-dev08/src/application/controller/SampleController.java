package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class SampleController {
	
	@FXML
	public void showDefineNewCategoryPage(ActionEvent event) {
		try {
			// Load the new page FXML file
	        Parent defineNewCategoryPage = FXMLLoader.load(getClass().getClassLoader().getResource("view/DefineNewCategory.fxml"));
	        // Get the current stage (window) from the event that triggered the method call
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        // Set the scene with the new page
	        stage.setScene(new Scene(defineNewCategoryPage));
	        // Optional: Set the title of the new window (stage)
	        stage.setTitle("Define New Category");
	        // Show the new scene
	        stage.show();
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	@FXML
	public void showDefineNewStoragePage(ActionEvent event) {
		try {
			// Load the new page FXML file
	        Parent defineNewCategoryPage = FXMLLoader.load(getClass().getClassLoader().getResource("view/DefineNewStorage.fxml"));
	        // Get the current stage (window) from the event that triggered the method call
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        // Set the scene with the new page
	        stage.setScene(new Scene(defineNewCategoryPage));
	        // Optional: Set the title of the new window (stage)
	        stage.setTitle("Define New Storage");
	        // Show the new scene
	        stage.show();
		} catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	@FXML
    public void showDefineNewAssetPage(ActionEvent event) {
        try {
            // Load the new page FXML file
            Parent defineNewAssetPage = FXMLLoader.load(getClass().getClassLoader().getResource("view/DefineNewAsset.fxml"));
            // Get the current stage (window) from the event that triggered the method call
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Set the scene with the new page
            stage.setScene(new Scene(defineNewAssetPage));
            // Optional: Set the title of the new window (stage)
            stage.setTitle("Define New Asset");
            // Show the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
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
}
