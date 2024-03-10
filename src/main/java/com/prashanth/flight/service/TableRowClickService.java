package com.prashanth.flight.service;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.model.SelectedTableRow;
import com.prashanth.flight.repository.SelectedTableRowRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.prashanth.flight.util.CommonUtil.isNotNullOrEmpty;
import static com.prashanth.flight.util.CommonUtil.mouseClickEvent;

@Service
@AllArgsConstructor
public class TableRowClickService {
   private final SelectedTableRowRepository selectedTableRowRepository;
   private final DashBoardService dashBoardService;

    public void handleTableRowClick(MouseEvent event, TableView<Flight> tableView, Button bookButton,Button downloadPdf,
                                    BorderPane bookingPane, GridPane dashboardPane,BorderPane loginPane) {
        if (Boolean.TRUE.equals(mouseClickEvent(event))) { // Single-click
            Flight selectedFlight = tableView.getSelectionModel().getSelectedItem();
            if (isNotNullOrEmpty(selectedFlight)) {
                downloadPdf.setVisible(true);
                bookButton.setVisible(true);
                tableView.setVisible(false);
                bookingPane.setVisible(false);
                loginPane.setVisible(false);

                dashboardPane.setVisible(true);
                storeBookingData(
                        selectedFlight.getAirline(),
                        selectedFlight.getOrigin(),
                        selectedFlight.getDestination(),
                        selectedFlight.getPrice(),
                        selectedFlight.getDepartDate(),
                        selectedFlight.getReturnDate(),
                        selectedFlight.getFlightSlot(),
                        selectedFlight.getFlightType());

            }
        }
    }
    private void storeBookingData(String airline,String origin,String destination,Double price,
                                  String departDate,String returnDate,String flightSlot,String flightType){
        SelectedTableRow selectedTableRow = new SelectedTableRow();
        selectedTableRow.setId("1");
        selectedTableRow.setAirline(airline);
        selectedTableRow.setOrigin(origin);
        selectedTableRow.setDestination(destination);
        selectedTableRow.setDepartDate(departDate);
        selectedTableRow.setReturnDate(returnDate);
        selectedTableRow.setFlightSlot(flightSlot);
        selectedTableRow.setFlightType(flightType);
        selectedTableRow.setPrice(price);
        selectedTableRowRepository.save(selectedTableRow);
    }
}
