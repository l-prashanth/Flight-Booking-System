package com.prashanth.flight.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SelectedTableRow {
    @Id
    private String id;
    private String airline;

    private String origin;
    private String destination;
    private double price;
    private String flightSlot;
    private String flightType;
    private String departDate;
    private String returnDate;
    public StringProperty flightTypeProperty() {
        return new SimpleStringProperty(this, "flightType", flightType);
    }
    public StringProperty flightSlotProperty() {
        return new SimpleStringProperty(this, "flightSlot", flightSlot);
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

    public StringProperty departDateProperty() {
        return new SimpleStringProperty(this, "departDate", departDate);

    }
    public StringProperty returnDateProperty() {
        return new SimpleStringProperty(this, "returnDate", returnDate);
    }

}
