package com.prashanth.flight.service;

import com.prashanth.flight.controller.UIController;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaFXInitializer {

    @Autowired
    private UIController uiController;

//    public void init(Stage primaryStage) {
//        uiController.setupUI(primaryStage);
//    }
    public void init(Stage primaryStage) {
        Platform.runLater(() -> uiController.setupUI(primaryStage));
    }
}