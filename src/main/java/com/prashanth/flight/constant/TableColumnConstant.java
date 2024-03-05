package com.prashanth.flight.constant;

import com.prashanth.flight.model.Flight;
import javafx.scene.control.TableColumn;

public class TableColumnConstant {
    public static  final TableColumn<Flight, String>  airlineColumn = new TableColumn<>("airline");
    public static final TableColumn<Flight, String> originColumn = new TableColumn<>("origin");
    public  static final TableColumn<Flight, String> destinationColumn = new TableColumn<>("destination");

    public static final TableColumn<Flight, Double> priceColumn = new TableColumn<>("price");
    public static final TableColumn<Flight, String> flightSlotColumn = new TableColumn<>("flightSlot");
    public static final TableColumn<Flight, String> flightTypeColumn = new TableColumn<>("flightType");
}
