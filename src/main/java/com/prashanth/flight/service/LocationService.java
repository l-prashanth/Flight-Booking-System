package com.prashanth.flight.service;

import javafx.scene.control.ComboBox;
import org.springframework.stereotype.Service;

import static com.prashanth.flight.util.CommonUtil.fxLocationList;
import static com.prashanth.flight.util.CommonUtil.isNotNullOrEmpty;

@Service
public class LocationService {
    public void fromLocationListener(ComboBox<String> fromLocationOption, ComboBox<String> toLocationOption){
        fromLocationOption.valueProperty().addListener((observable, oldValue, newValue) -> {
            initializeToLocation(toLocationOption);
            System.out.println("From Location:\t"+ newValue);
            if (isNotNullOrEmpty(newValue))
                toLocationOption.getItems().remove(newValue);
        });
    }
    public void initializeFromLocation(ComboBox<String> fromLocationOption) {
        fromLocationOption.setItems(fxLocationList());
    }

    public void initializeToLocation(ComboBox<String> toLocationOption) {
        toLocationOption.setItems(fxLocationList());
    }
    public void toLocationListener(ComboBox<String> fromLocationOption,ComboBox<String> toLocationOption) {
        toLocationOption.valueProperty().addListener((observable, oldValue, newValue) -> {
            initializeFromLocation(fromLocationOption);
            System.out.println("To Location:\t"+newValue);
            if (isNotNullOrEmpty(newValue))
                fromLocationOption.getItems().remove(newValue);
        });
    }
}
