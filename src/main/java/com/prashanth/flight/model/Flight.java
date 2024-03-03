package com.prashanth.flight.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@AllArgsConstructor
@Document(collection = "flights")
public class Flight {

    @Id
    private String id;

    private String airline;

    private  String origin;
    private  String destination;
    private  double price;


    // Default constructor
    public Flight() {}

    // Constructor with necessary fields
    public Flight(String origin, String destination, double price) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }


    // Other properties and methods...

    // JavaFX property for the 'id' field
    public StringProperty idProperty() {
        return new SimpleStringProperty(this, "id", id);
    }

    // JavaFX property for the 'airline' field
    public StringProperty airlineProperty() {
        return new SimpleStringProperty(this, "airline", airline);
    }

    // JavaFX property for the 'origin' field
    public StringProperty originProperty() {
        return new SimpleStringProperty(this, "origin", origin);
    }

    // JavaFX property for the 'destination' field
    public StringProperty destinationProperty() {
        return new SimpleStringProperty(this, "destination", destination);
    }

    // JavaFX property for the 'price' field
    public SimpleDoubleProperty priceProperty() {
        return new SimpleDoubleProperty(this, "price", price);
    }
}
