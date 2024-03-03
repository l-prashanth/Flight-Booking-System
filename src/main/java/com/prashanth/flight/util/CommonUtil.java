package com.prashanth.flight.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Component
public class CommonUtil {

    public static List<String> locationList(){
        return Arrays.asList("Delhi", "Mumbai", "Hyderabad", "Bangalore", "Chennai");
    }
    public static ObservableList<String> fxLocationList(){
        return FXCollections.observableArrayList(locationList());
    }
}
