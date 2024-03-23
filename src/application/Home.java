package application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


public class Home extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Button defCatBtn = new Button();
			defCatBtn.setText("Define New Category");
			defCatBtn.setFont(Font.font("Arial", FontWeight.BOLD, 24));
			//defCatBtn.setTextFill(Color.rgb(212,  180, 131));
			
			defCatBtn.setOnAction(new EventHandler<ActionEvent> () {
	
				@Override
				public void handle(ActionEvent event) {
					primaryStage.setScene(scene);
				}
				
			});
			
			BorderPane root = new BorderPane();
			//root.getChildren().add(defCatBtn);
			root.setTop(defCatBtn);
			BorderPane.setAlignment(defCatBtn, Pos.CENTER_RIGHT);
			
			Scene scene = new Scene(root, 400, 400);
			
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
