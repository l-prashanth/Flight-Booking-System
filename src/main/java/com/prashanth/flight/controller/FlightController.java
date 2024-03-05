package com.prashanth.flight.controller;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static com.prashanth.flight.util.CommonUtil.*;
import static com.prashanth.flight.util.CommonUtil.fxFlightTypeList;

@Controller

public class FlightController {
    @Autowired
    private TableRowClickService tableRowClickService;
    @Autowired
    private LoadFlightService loadFlightService;
    @Autowired
    private ColumnPropertyService columnPropertyService;
    @Autowired
    private DepartDateService departDateService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private FlightTypeService flightTypeService;
    @Autowired
    private FlightDateService flightDateService;


    @FXML
    private TableView<Flight> tableView;

    @FXML
    private ComboBox<String> fromLocationOption;

    @FXML
    private ComboBox<String> toLocationOption;

    @FXML
    private Button bookButton;
    @FXML
    private ComboBox<String> flightTypeOption;
    @FXML
    private DatePicker departDate;
    @FXML
    private DatePicker returnDate;

    @FXML
    public void initialize() {
        initializeTable();
        locationHandler();
        flightTypeHandler();
        departDateHandler();
    }
    public void locationHandler(){
        locationService.initializeFromLocation(fromLocationOption);
        locationService.initializeToLocation(toLocationOption);
        locationService.fromLocationListener(fromLocationOption,toLocationOption);
        locationService.toLocationListener(fromLocationOption,toLocationOption);
    }
    public void flightTypeHandler(){
        flightTypeService.initializeFlightTypeOptions(flightTypeOption);
        flightTypeService.flightTypeListener(flightTypeOption);
    }
    private void flightDateHandler(){
        flightDateService.initializeDepartDate(departDate);
        flightDateService.initializeReturnDate(returnDate);
        flightDateService.departDateListener(departDate);
        flightDateService.returnDateListener(returnDate);
    }
    public void departDateHandler(){
        departDateService.initializeDepartDate(departDate);
        departDateService.departDateListener(departDate);
    }

    private void initializeTable() {
        columnPropertyService.tableColumnProperties(tableView);
    }

    @FXML
    private void findFlightButtonClick() {
        loadFlightService.findFlightButtonClick(fromLocationOption, toLocationOption, tableView);
    }

    @FXML
    public void handleTableRowClick(MouseEvent event) {
        tableRowClickService.handleTableRowClick(event, tableView, bookButton);
    }

    @FXML
    private void handleBookingButtonClick() {

    }


}