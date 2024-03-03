package com.prashanth.flight;

import com.prashanth.flight.controller.UIController;
import com.prashanth.flight.service.JavaFXInitializer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

//@SpringBootApplication
//public class FlightApplication extends Application {
////	@Autowired
//	@Override
//	public void start(Stage primaryStage) {
//		UIController uiController = new UIController();
//		// The UI setup logic is now in a separate class
////		uiController.setupUI(primaryStage);
//		uiController.bookUi(primaryStage);
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//}

@SpringBootApplication
public class FlightApplication extends Application {
	private ConfigurableApplicationContext applicationContext;
	private Parent rootNode;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		try {
			applicationContext = SpringApplication.run(FlightApplication.class);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
			loader.setControllerFactory(applicationContext::getBean);
			rootNode = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(rootNode, 800, 600));
		primaryStage.setTitle("Flight Booking System");
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
	}
}

//@SpringBootApplication
//public class FlightApplication extends Application {
//
//	private ConfigurableApplicationContext context;
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public void init() {
//		CompletableFuture.runAsync(() -> context = SpringApplication.run(FlightApplication.class));
//	}
//
//	@Override
//	public void start(Stage primaryStage) {
//		CompletableFuture.runAsync(() -> context.getBean(JavaFXInitializer.class).init(primaryStage))
//				.thenRun(() -> {
//					// Notify JavaFX application initialization is complete
//					CountDownLatch latch = new CountDownLatch(1);
//					Platform.runLater(latch::countDown);
//					try {
//						latch.await();
//					} catch (InterruptedException e) {
//						Thread.currentThread().interrupt();
//						throw new RuntimeException("Error waiting for JavaFX initialization", e);
//					}
//				});
//	}
//
//	@Override
//	public void stop() {
//		// Close Spring context when JavaFX application is closed
//		context.close();
//	}
//}

//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		Button btn1 = new Button("Say, Hello World");
//		btn1.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("hello world");
//			}
//		});
//		StackPane root = new StackPane();
//		root.getChildren().add(btn1);
//		Scene scene = new Scene(root, 600, 400);
//		primaryStage.setTitle("First JavaFX Application");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//}

