package com.prashanth.flight.model;

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
}
