package com.prashanth.flight.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Component
public class CommonUtil {

    public static List<String> locationList(){
        return Arrays.asList("Delhi", "Mumbai", "Hyderabad", "Bangalore", "Chennai");
    }
}
