package com.prashanth.flight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class FlightApplication extends Application {
	private ConfigurableApplicationContext applicationContext;
	private Parent rootNode;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException {
		applicationContext = SpringApplication.run(FlightApplication.class);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BookFlight.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		rootNode = loader.load();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(rootNode, 1000, 800));
		primaryStage.setTitle("Flight Booking System");
		primaryStage.show();
	}

	@Override
	public void stop()  {
		applicationContext.close();
	}
}


