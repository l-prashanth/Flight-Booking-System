package com.prashanth.flight.service;

import com.prashanth.flight.model.LoginCredentials;
import com.prashanth.flight.repository.LoginRepository;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {
    private LoginRepository loginRepository;

    public Boolean handleLogin(TextField usernameField, PasswordField passwordField, BorderPane bookingPane) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Username: " + username + ", Password: " + password);

        LoginCredentials loginCredential = loginRepository.findAll().get(0);

        if (loginCredential.getUsername().equals(username) && loginCredential.getPassword().equals(password)) {
            bookingPane.setVisible(true);
            return true;
        } else {
            // Show error message
            displayErrorMessage();

            // Highlight the fields in red
            usernameField.setStyle("-fx-border-color: red;");
            passwordField.setStyle("-fx-border-color: red;");

            return false;
        }
        // Add your login logic here
    }

    private void displayErrorMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Wrong username or password");
        alert.showAndWait();
    }
}
