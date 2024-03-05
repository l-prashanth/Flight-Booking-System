package com.prashanth.flight.service;

import com.prashanth.flight.model.Flight;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.prashanth.flight.constant.TableColumnConstant.*;
import static com.prashanth.flight.constant.TableColumnConstant.priceColumn;

@Service
public class ColumnPropertyService {
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
}
