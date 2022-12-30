package javaChapter17;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Sample extends Application {
	public static void main(String[] args) {
		launch(args);	// Sample ��ü ���� �� ���� ������ ����
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		Label label = new Label();
		label.setText("Hello JavaFX");
		label.setFont(new Font(50));
		
		Button button = new Button();
		button.setText("Ȯ��");
		button.setOnAction(event -> Platform.exit());
		
		root.getChildren().add(label);
		root.getChildren().add(button);
		
		Scene scene = new Scene(root);	// VBox�� ��Ʈ �����̳ʷ� Scene ����
		
		primaryStage.setTitle("Sample Application");
		primaryStage.setScene(scene);
		primaryStage.show();	// ������ �����ֱ�
	}
}