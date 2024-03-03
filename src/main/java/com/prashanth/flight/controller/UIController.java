package com.prashanth.flight.controller;

import com.prashanth.flight.model.Booking;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@AllArgsConstructor
@Controller
public class UIController {


    //    public void setupUI(Stage primaryStage) {
//        Button btn1 = new Button("Say, Hello World");
//        btn1.setOnAction(arg0 -> System.out.println("Hello world"));
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn1);
//        Scene scene = new Scene(root, 600, 400);
//
//        primaryStage.setTitle("First JavaFX Application");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
    public void setupUI(Stage primaryStage) {
        Platform.runLater(() -> {
            Button btn1 = new Button("Say, Hello World");
            btn1.setOnAction(arg0 -> System.out.println("Hello world"));

            StackPane root = new StackPane();
            root.getChildren().add(btn1);
            Scene scene = new Scene(root, 600, 400);

            primaryStage.setTitle("First JavaFX Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }
//    @FXML
//    private TextField passengerNameTextField;
//
//    @FXML
//    private TextField flightNumberTextField;
//
////    @FXML
//    public void bookUi(Stage primaryStage) {
//        Button btn1 = new Button("Say, Hello World");
//        btn1.setOnAction(arg0 -> System.out.println("Hello world"));
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn1);
//        Scene scene = new Scene(root, 600, 400);
//
//        primaryStage.setTitle("First JavaFX Application");
//        primaryStage.setScene(scene);
//        primaryStage.show();
////        String passengerName = passengerNameTextField.getText();
////        String flightNumber = flightNumberTextField.getText();
//
////        // You might want to validate further and handle exceptions
////        Booking newBooking = new Booking();
////        newBooking.setPassengerName(passengerName);
////        newBooking.setFlightNumber(flightNumber);
//
////            Button btn1 = new Button("Say, Hello World");
////            btn1.setOnAction(arg0 -> System.out.println("Hello world"));
////
////            StackPane root = new StackPane();
////            root.getChildren().add(btn1);
////            Scene scene = new Scene(root, 600, 400);
////
////            primaryStage.setTitle("First JavaFX Application");
////            primaryStage.setScene(scene);
////            primaryStage.show();
//
//    }

    public void bookUi(Stage primaryStage) {
        // Create TextFields
        TextField passengerNameTextField = new TextField();
        TextField flightNumberTextField = new TextField();

        Booking newBooking = new Booking();
        newBooking.setPassengerName(passengerNameTextField.getText());
        newBooking.setFlightNumber(flightNumberTextField.getText());

//        Button btn1 = new Button("Say, Hello World");
//        btn1.setOnAction(arg0 -> {
//            // Get text from TextFields
//            String passengerName = passengerNameTextField.getText();
//            String flightNumber = flightNumberTextField.getText();
//
//            // You might want to validate further and handle exceptions
//            // Booking newBooking = new Booking();
//            // newBooking.setPassengerName(passengerName);
//            // newBooking.setFlightNumber(flightNumber);
//
//            System.out.println("Passenger Name: " + passengerName);
//            System.out.println("Flight Number: " + flightNumber);
//        });

        StackPane root = new StackPane();
        root.getChildren().addAll(passengerNameTextField, flightNumberTextField);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Book Flight");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

