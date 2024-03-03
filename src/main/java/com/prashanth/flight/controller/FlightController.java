package com.prashanth.flight.controller;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.model.RecordOption;
import com.prashanth.flight.repository.FlightRepository;

import com.prashanth.flight.repository.LocationRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.prashanth.flight.util.CommonUtil.fxLocationList;

@Controller

public class FlightController {

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
//        loadData();
//        initializeFromBox();
        initializeTable();
//        fromOptionListener();
//        initializeToBox();
        optionHandler();
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

        tableView.getColumns().addAll(airlineColumn, originColumn, destinationColumn, priceColumn);
    }

    private void initializeFromBox() {
        fromOption.setItems(fxLocationList());
    }
    private void optionHandler(){
        initializeFromBox();
        initializeToBox();
        fromOptionListener();
        toOptionListener();
    }

    private void fromOptionListener() {
        fromOption.valueProperty().addListener((observable, oldValue, newValue) -> {
            initializeToBox();

            if (newValue != null) {
                toOption.getItems().remove(newValue);
            }
            RecordOption recordOption = new RecordOption();
            recordOption.setFromLocation(newValue);
            System.out.println("From Option: " + newValue);
        });
    }

    private void initializeToBox() {
        toOption.setItems(fxLocationList());
    }

    private void toOptionListener() {
        toOption.valueProperty().addListener((observable, oldValue, newValue) -> {
            initializeFromBox();

            if (newValue != null) {
                fromOption.getItems().remove(newValue);
            }
            RecordOption recordOption = new RecordOption();
            recordOption.setToLocation(newValue);
            System.out.println("To Option: " + newValue);
        });
    }

    @FXML
    private void handleButtonClick() {
        // Implement your logic here when the button is clicked.
        System.out.println("Button clicked!");

        // Assuming your ComboBoxes are named fromOption and toOption
        String origin = fromOption.getValue();
        String destination = toOption.getValue();


        tableView.setVisible(true);

        // Call the loadFilteredData method with the selected values
        loadFilteredData(origin, destination);
        tableView.refresh();

    }

    // Other existing code...

    public void loadFilteredData(String origin, String destination) {
        List<Flight> entities = repository.findByOriginAndDestination(origin, destination);
        System.out.println("check"+entities);
        tableView.getItems().clear(); // Clear existing items before adding new ones
        tableView.getItems().addAll(entities);
    }

    private void loadData() {
        List<Flight> entities = repository.findAll();
        tableView.getItems().addAll(entities);
    }
    @FXML
    public void handleTableRowClick(MouseEvent event) {
        if (event.getClickCount() == 1) { // Single-click
            Flight selectedFlight = tableView.getSelectionModel().getSelectedItem();

            if (selectedFlight != null) {
                // Access the properties of the selected flight
                String airline = selectedFlight.getAirline();
                String origin = selectedFlight.getOrigin();
                String destination = selectedFlight.getDestination();
                double price = selectedFlight.getPrice();

                // Do something with the fetched values
                System.out.println("Selected Flight: " + airline + ", " + origin + ", " + destination + ", " + price);
            }
        }
    }
}