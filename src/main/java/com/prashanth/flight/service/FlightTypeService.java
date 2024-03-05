package com.prashanth.flight.service;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.prashanth.flight.util.CommonUtil.fxFlightTypeList;

@Service
public class FlightTypeService {
    public void initializeFlightTypeOptions(ComboBox<String> flightTypeOption) {
        flightTypeOption.setItems(fxFlightTypeList());
    }
    public void flightTypeListener(ComboBox<String> flightTypeOption) {
        flightTypeOption.valueProperty().addListener((observable, oldValue, newValue)
                -> System.out.println("FlightType:\t"+ newValue));
    }
}
