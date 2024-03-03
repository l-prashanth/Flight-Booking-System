package com.prashanth.flight.model;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Location {
    static List<String>  locationList = Arrays.asList("Delhi", "Mumbai", "Hyderabad", "Bangalore", "Chennai");
}
