package com.prashanth.flight.controller;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.model.Location;
import com.prashanth.flight.repository.FlightRepository;
import com.prashanth.flight.service.FlightService;
import com.prashanth.flight.util.CommonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.prashanth.flight.util.CommonUtil.locationList;

@Controller

public class MainController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository repository;


    @FXML
    private TableView<Flight> flightTableView;

    @FXML
    private TableView<Flight> tableView;

    @FXML
    private ComboBox<String> fromOption;

    @FXML
    private ComboBox<String> toOption;

    @FXML
    public void initialize() {
        loadData();
        initializeFromBox();
        initializeTable();
        fromOptionListener();
    }

    private void initializeTable() {
        TableColumn<Flight, String> airlineColumn = new TableColumn<>("airline");
        airlineColumn.setCellValueFactory(cellData -> cellData.getValue().airlineProperty());

        TableColumn<Flight, String> originColumn = new TableColumn<>("origin");
        originColumn.setCellValueFactory(cellData -> cellData.getValue().originProperty());

        TableColumn<Flight, String> destinationColumn = new TableColumn<>("destination");
        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());

        TableColumn<Flight, Double> priceColumn = new TableColumn<>("price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        tableView.getColumns().addAll(airlineColumn, originColumn, destinationColumn,priceColumn);
    }
    private void initializeFromBox() {
//        Location location = new Location();
//        ObservableList<String> options = FXCollections.observableArrayList(
//                "Delhi", "Mumbai", "Hyderabad", "Bangalore","Chennai"
//        );
        ObservableList<String> options = FXCollections.observableArrayList(locationList());
        fromOption.setItems(options);
        System.out.println("Location"+fromOption.getItems());
    }
    private void fromOptionListener() {
        fromOption.valueProperty().addListener((observable, oldValue, newValue) -> System.out.println("Selected Option: " + newValue));
    }

    private void loadData() {
        List<Flight> entities = repository.findAll();
        tableView.getItems().addAll(entities);
    }

    public void refreshFlightTable() {
        // Retrieve flights from the service and update the table
        List<Flight> flights = flightService.getAllFlights();
        flightTableView.getItems().setAll(flights);
    }
}