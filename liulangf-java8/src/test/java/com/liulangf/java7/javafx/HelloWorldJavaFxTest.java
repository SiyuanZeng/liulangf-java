package com.liulangf.java7.javafx;

import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import org.junit.Test;

public class HelloWorldJavaFxTest {

	class MyFx extends javafx.application.Application {

		@Override
		public void start(Stage stage) throws Exception {
			Label message = new Label("Hello, JavaFx!");
			message.setFont(new Font(100));
			stage.setScene(new Scene(message));
			stage.setTitle("Hello");
			stage.show();
		}
	}
	
	@Test
	public void test() {
		MyFx a = new MyFx();
	}

}
