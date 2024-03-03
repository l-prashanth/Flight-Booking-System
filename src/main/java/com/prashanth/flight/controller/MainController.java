package com.prashanth.flight.controller;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import com.prashanth.flight.service.FlightService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private FlightService flightService;

    @FXML
    private TableView<Flight> flightTableView;

//    @FXML
//    private TableColumn<Flight, String> airlineColumn;
//
//    @FXML
//    private TableColumn<Flight, String> originColumn;
//
//    @FXML
//    private TableColumn<Flight, String> destinationColumn;
//
//    @FXML
//    private TableColumn<Flight, Double> priceColumn;

    @FXML
    public void initialize() {
        initializeTable();
        loadData();
//        refreshFlightTable();
    }


    //    private void initializeColumns() {
//        // Associate columns with the properties of the Flight class
//        airlineColumn.setCellValueFactory(cellData -> cellData.getValue().airlineProperty());
//        airlineColumn.setCellValueFactory(cellData -> cellData.getValue().airlineProperty());
//        originColumn.setCellValueFactory(cellData -> cellData.getValue().originProperty());
//        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());
//        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
//
//
//    }
    @FXML
    private TableView<Flight> tableView;

    @Autowired
    private FlightRepository repository;


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