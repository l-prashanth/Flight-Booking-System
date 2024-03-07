package com.prashanth.flight.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "flights")
public class Flight {

    @Id
    private String id;

    private String airline;

    private String origin;
    private String destination;
    private double price;
    private String departDate;
    private String returnDate;
    private String flightSlot;
    private String flightType;
    // JavaFX property for the 'variable' field


    public StringProperty flightSlotProperty() {
        return new SimpleStringProperty(this, "flightSlot", flightSlot);
    }

    public StringProperty flightTypeProperty() {
        return new SimpleStringProperty(this, "flightType", flightType);
    }

    public StringProperty airlineProperty() {
        return new SimpleStringProperty(this, "airline", airline);
    }

    public StringProperty originProperty() {
        return new SimpleStringProperty(this, "origin", origin);
    }

    public StringProperty destinationProperty() {
        return new SimpleStringProperty(this, "destination", destination);
    }

    public SimpleDoubleProperty priceProperty() {
        return new SimpleDoubleProperty(this, "price", price);
    }
}
