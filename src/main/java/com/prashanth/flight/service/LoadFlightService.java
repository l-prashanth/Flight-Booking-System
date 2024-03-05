package com.prashanth.flight.service;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadFlightService {
    @Autowired
    FlightRepository flightRepository;
    public void loadFilteredData(String origin, String destination, TableView<Flight> tableView) {
        List<Flight> entities = flightRepository.findByOriginAndDestination(origin, destination);
        tableView.getItems().clear(); // Clear existing items before adding new ones
        tableView.getItems().addAll(entities);
    }
    public void findFlightButtonClick(ComboBox<String> fromOption, ComboBox<String> toOption,TableView<Flight> tableView) {
        String origin = fromOption.getValue();
        String destination = toOption.getValue();
        tableView.setVisible(true);
        loadFilteredData(origin, destination,tableView);
        tableView.refresh();
    }

}
