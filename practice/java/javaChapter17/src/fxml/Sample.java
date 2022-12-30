package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sample extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		Parent root2 = FXMLLoader.load(getClass().getResource("AnchorPane.fxml"));
		Parent root3 = FXMLLoader.load(getClass().getResource("Box.fxml"));
		Scene scene = new Scene(root3);
		
		primaryStage.setTitle("Sample Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
