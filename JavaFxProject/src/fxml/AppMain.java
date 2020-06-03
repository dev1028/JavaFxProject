package fxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);

		TextField textField = new TextField();
		textField.setPrefWidth(200);
		textField.setPrefHeight(100);

		Button button = new Button();
		button.setText("확인");
		button.setPrefSize(100, 100);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent evt) {
				// TODO Auto-generated method stub
				textField.setText("확인을 눌렀습니다.");
			}

		});

		Button button1 = new Button();
		button1.setText("취소");
		button1.setPrefSize(100, 100);
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent evt) {
				// TODO Auto-generated method stub
				textField.setText(null);
			}

		});

		ObservableList<Node> list = hbox.getChildren();
		list.add(textField);
		list.add(button);
		list.add(button1);

		Scene scene = new Scene(hbox);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
