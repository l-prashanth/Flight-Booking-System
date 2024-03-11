package com.prashanth.flight.service;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class LoadFlightService {
    private final FlightRepository flightRepository;
    public  void loadFilteredData(String origin, String destination,
                                 String departDate, String returnDate, String flightType, TableView<Flight> tableView) {
        List<Flight> entities = findFlightsByCriteria(origin, destination, departDate, returnDate, flightType);
        tableView.getItems().clear(); // Clear existing items before adding new ones
        tableView.getItems().addAll(entities);
    }

    public List<Flight> findFlightsByCriteria(String origin, String destination, String departDate,
                                              String returnDate, String flightType) {
        printFlightInputValue(origin,destination,departDate,returnDate,flightType);
        return flightRepository.findByOriginAndDestinationAndDepartDateAndReturnDateAndFlightType(
                origin.trim(), destination.trim(), departDate.trim(), returnDate.trim(), flightType.trim());
    }

    public void findFlightButtonClick(ComboBox<String> fromOption, ComboBox<String> toOption, String departDate,
                                      String returnDate, ComboBox<String> flightTypeOption, TableView<Flight> tableView) {
        String origin = fromOption.getValue();
        String destination = toOption.getValue();
        String flightType = flightTypeOption.getValue();

        tableView.setVisible(true);
        loadFilteredData(origin, destination, departDate, returnDate, flightType, tableView);
        tableView.refresh();
    }
    public void printFlightInputValue(String origin, String destination, String departDate,
                                      String returnDate, String flightType){
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("DepartDate: " + departDate);
        System.out.println("ReturnDate: " + returnDate);
        System.out.println("FlightType: " + flightType);
    }
}
