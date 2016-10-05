package com.liulangf.java7.javafx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJFX  extends javafx.application.Application {

	@Override
	public void start(Stage stage) throws Exception {
		Label message = new Label("Hello, JavaFx!");
		message.setFont(new Font(100));
		stage.setScene(new Scene(message));
		stage.setTitle("Hello");
		stage.show();
	}
	
}
