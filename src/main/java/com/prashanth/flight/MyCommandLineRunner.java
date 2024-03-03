//package com.prashanth.flight;
//
//import com.prashanth.flight.controller.MainController;
//import com.prashanth.flight.controller.UIController;
//import javafx.application.Platform;
//import javafx.stage.Stage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private MainController mainController;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Your logic here
//
//        // Example of running UI code on the JavaFX Application Thread
//        Platform.runLater(() -> {
//            // You can call methods from your MainController here
//            mainController.refreshFlightTable();
//        });
//    }
//}
