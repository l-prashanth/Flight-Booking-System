package com.prashanth.flight.configuration;

import com.prashanth.flight.model.Flight;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

@Component
public class TableConfig {

    public static TableColumn<Flight, String> airlineColumn1(){
        return new TableColumn<>("airline");
    }


}
