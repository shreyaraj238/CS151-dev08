package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load Home page FXML file
			VBox root = (VBox)FXMLLoader.load(getClass().getClassLoader().getResource("view/Main.fxml"));
			// Sets stage for Home page elements from FXML file
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			// Show Home page scene
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
