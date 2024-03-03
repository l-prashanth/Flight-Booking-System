// JavaFxApplicationEvent.java
package com.prashanth.flight.controller;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

public class JavaFxApplicationEvent extends ApplicationEvent {

    private final Stage stage;

    public JavaFxApplicationEvent(Object source, Stage stage) {
        super(source);
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}
