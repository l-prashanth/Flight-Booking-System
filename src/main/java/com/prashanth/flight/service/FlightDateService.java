package com.prashanth.flight.service;

import javafx.scene.control.DatePicker;
import org.springframework.stereotype.Service;

import static com.prashanth.flight.util.CommonUtil.dateUIFormatter;
import static com.prashanth.flight.util.CommonUtil.formatDateMonthYear;

@Service
public class FlightDateService {
    public void initializeDepartDate(DatePicker departDate) {
        dateUIFormatter(departDate);
    }

    public void departDateListener(DatePicker departDate) {
        departDate.setOnAction(event -> System.out.println("DepartDate:\t" + formatDateMonthYear(departDate)));
    }

    public void initializeReturnDate(DatePicker returnDate) {
        dateUIFormatter(returnDate);
    }

    public void returnDateListener(DatePicker returnDate) {
        returnDate.setOnAction(event -> System.out.println("ReturnDate:\t" + formatDateMonthYear(returnDate)));
    }
}
