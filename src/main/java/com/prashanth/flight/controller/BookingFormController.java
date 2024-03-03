package com.prashanth.flight.controller;

import com.prashanth.flight.model.Booking;
import com.prashanth.flight.service.BookingService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingFormController {

    @FXML
    private TextField passengerNameTextField;

    @FXML
    private TextField flightNumberTextField;

    private final BookingService bookingService;

    @Autowired
    public BookingFormController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @FXML
    private void bookFlight() {
        // Validate user input
        if (validateInput()) {
            // If input is valid, create a new booking
            String passengerName = passengerNameTextField.getText();
            String flightNumber = flightNumberTextField.getText();

            // You might want to validate further and handle exceptions
            Booking newBooking = new Booking();
            newBooking.setPassengerName(passengerName);
            newBooking.setFlightNumber(flightNumber);

            // Save the booking
            bookingService.saveBooking(newBooking);

            // Show success message
            showSuccessAlert("Booking successful!");
        }
    }

    private boolean validateInput() {
        // Perform validation here
        String passengerName = passengerNameTextField.getText();
        String flightNumber = flightNumberTextField.getText();

        if (passengerName.isEmpty() || flightNumber.isEmpty()) {
            showErrorAlert("Please fill in all fields.");
            return false;
        }

        // Additional validation logic can be added as needed

        return true;
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
