package com.prashanth.flight.model;

// Booking.java

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Booking {

    @Id
    private String id;
    private String passengerName;
    private String flightNumber;
    // Other fields, getters, and setters
}

