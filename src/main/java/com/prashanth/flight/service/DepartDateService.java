package com.prashanth.flight.service;

import javafx.scene.control.DatePicker;
import org.springframework.stereotype.Service;

import static com.prashanth.flight.util.CommonUtil.dateUIFormatter;
import static com.prashanth.flight.util.CommonUtil.formatDateMonthYear;

@Service
public class DepartDateService {
    public void initializeDepartDate(DatePicker departDate){
        dateUIFormatter(departDate);
    }
    public void departDateListener(DatePicker departDate) {
        departDate.setOnAction(event -> formatDateMonthYear(departDate));
    }
}
