package com.prashanth.flight.service;

import com.prashanth.flight.model.SelectedTableRow;
import com.prashanth.flight.repository.FlightRepository;
import com.prashanth.flight.repository.SelectedTableRowRepository;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopulateSelectedFlightDetails {
    private final SelectedTableRowRepository selectedTableRowRepository;
    public void populateFlightDetails(Label originLabel, Label destinationLabel, Label departDateLabel,
                                      Label returnDateLabel, Label flightTypeLabel,Label flightSlotLabel,
                                      Label flightPriceLabel){
        SelectedTableRow flightDetails = selectedTableRowRepository.findAll().get(0);
        originLabel.textProperty().bind(flightDetails.originProperty());
        destinationLabel.textProperty().bind(flightDetails.destinationProperty());
        departDateLabel.textProperty().bind(flightDetails.departDateProperty());
        returnDateLabel.textProperty().bind(flightDetails.returnDateProperty());
        flightTypeLabel.textProperty().bind(flightDetails.flightTypeProperty());
        flightSlotLabel.textProperty().bind(flightDetails.flightSlotProperty());
        flightPriceLabel.textProperty().bind(Bindings.createStringBinding(
                () -> String.valueOf(flightDetails.priceProperty().get()),
                flightDetails.priceProperty()
        ));
    }
}
