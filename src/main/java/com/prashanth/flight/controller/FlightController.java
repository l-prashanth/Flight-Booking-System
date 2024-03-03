//package com.prashanth.flight.controller;
//
//import com.prashanth.flight.model.Flight;
//import com.prashanth.flight.service.FlightService;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TextField;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
////@AllArgsConstructor
//@Controller
//public class FlightController implements Initializable {
//
//    @Autowired
//    private FlightService flightService;
//
//    @FXML
//    private TextField originTextField;
//
//    @FXML
//    private TextField destinationTextField;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println("Controller initialized.");
////        try {
////            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/flight_booking_app.fxml"));
////            loader.setController(this);  // Set the controller to this instance
////            loader.load();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @FXML
//    public void searchFlights() {
//        String origin = originTextField.getText();
//        String destination = destinationTextField.getText();
//
//        List<Flight> flights = flightService.searchFlights(origin, destination);
//
//        // Display the result in the UI (you can customize this part)
//        if (flights.isEmpty()) {
//            showAlert("No flights found!");
//        } else {
//            StringBuilder result = new StringBuilder("Found Flights:\n");
//            for (Flight flight : flights) {
//                result.append(flight.toString()).append("\n");
//            }
//            showAlert(result.toString());
//        }
//    }
//
//    private void showAlert(String message) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Flight Booking System");
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//}
//
