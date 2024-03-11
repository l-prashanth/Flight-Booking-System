package com.prashanth.flight.service;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import javafx.beans.binding.Bindings;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.prashanth.flight.constant.TableColumnConstant.*;
import static com.prashanth.flight.constant.TableColumnConstant.priceColumn;

@AllArgsConstructor
@Service
public class ColumnPropertyService {
    private final FlightRepository flightRepository;
    public void tableColumnProperties(TableView<Flight> tableView) {
        airlineColumn.setCellValueFactory(cellData -> cellData.getValue().airlineProperty());
        originColumn.setCellValueFactory(cellData -> cellData.getValue().originProperty());
        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        flightSlotColumn.setCellValueFactory(cellData -> cellData.getValue().flightSlotProperty());
        flightTypeColumn.setCellValueFactory(cellData -> cellData.getValue().flightTypeProperty());
        airlineColumn.setPrefWidth(100); // Adjust the width as needed
        originColumn.setPrefWidth(150);
        destinationColumn.setPrefWidth(150);
        priceColumn.setPrefWidth(75);
        flightSlotColumn.setPrefWidth(150);
        flightTypeColumn.setPrefWidth(100);

        List<TableColumn<Flight, ?>> columns = Arrays.asList(
                airlineColumn, originColumn, destinationColumn, priceColumn,flightTypeColumn,flightSlotColumn);
        tableView.getColumns().addAll(columns);
    }
    public void loadRecordCount(String origin, String destination,
                               String departDate, String returnDate, String flightType,TableView<Flight> tableView) {

        int recordCount= findFlightsByCriteria(origin, destination, departDate, returnDate, flightType).size();
        tableView.prefHeightProperty().bind(Bindings.size(tableView.getItems()).multiply(tableView.getFixedCellSize()).add(100));
    }

    public List<Flight> findFlightsByCriteria(String origin, String destination, String departDate,
                                              String returnDate, String flightType) {
        return flightRepository.findByOriginAndDestinationAndDepartDateAndReturnDateAndFlightType(
                origin, destination, departDate, returnDate, flightType
        );
    }
}
