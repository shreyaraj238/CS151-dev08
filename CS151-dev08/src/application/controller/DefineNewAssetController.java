package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DefineNewAssetController {
    @FXML
    private TextField assetName;
    @FXML
    private ChoiceBox<String> categoryChoiceBox;
    @FXML
    private ChoiceBox<String> locationChoiceBox;
    @FXML
    private DatePicker purchaseDate;
    @FXML
    private TextField purchasedValue;
    @FXML
    private DatePicker warrantyExpiration;
    @FXML
    private TextArea description;
    

    @FXML
    private void handleSaveButtonClick() {
        // Check if required fields are empty
        if (assetName.getText().trim().isEmpty() || categoryChoiceBox.getValue() == null || locationChoiceBox.getValue() == null) {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all required fields.");
            alert.showAndWait();
        }else {

        try {
            // Create a new CSV file if it doesn't exist
            File file = new File("assets.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Write the input text to the CSV file
            FileWriter csvWriter = new FileWriter(file, true);
            csvWriter.append(String.format("%s,%s,%s,%s,%s,%s,%s\n",
                    assetName.getText(),
                    categoryChoiceBox.getValue(),
                    locationChoiceBox.getValue(),
                    purchaseDate.getValue(),
                    description.getText(),
                    purchasedValue.getText(),
                    warrantyExpiration.getValue()
            ));
            csvWriter.flush();
            csvWriter.close();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Information");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Asset info has been saved!");
            successAlert.showAndWait();
            // Clear the input fields
            clearFields();

        } catch (IOException e) {
            e.printStackTrace();
            // Handle file writing error
        }
        }
    }

    @FXML
    private void showHomePage(ActionEvent event) {
        try {
            // Load the new page FXML file
            Parent defineNewAssetPage = FXMLLoader.load(getClass().getClassLoader().getResource("view/Main.fxml"));
            // Get the current stage (window) from the event that triggered the method call
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Set the scene with the new page
            stage.setScene(new Scene(defineNewAssetPage));
            // Optional: Set the title of the new window (stage)
            stage.setTitle("Home");
            // Show the new scene
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
