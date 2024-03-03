package com.prashanth.flight.controller;

// MainWindowController.java
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Component;

@Component
public class MainWindowController {

    @FXML
    private void openBookingForm() {
        // Logic to open the booking form
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Implement booking form logic here.");
        alert.showAndWait();
    }
}

