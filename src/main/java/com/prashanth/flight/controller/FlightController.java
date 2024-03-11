package com.prashanth.flight.controller;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static com.prashanth.flight.util.CommonUtil.formatDateMonthYear;

@Controller

public class FlightController {

    @Autowired
    private TableRowClickService tableRowClickService;
    @Autowired
    private LoadFlightService loadFlightService;
    @Autowired
    private ColumnPropertyService columnPropertyService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private FlightTypeService flightTypeService;
    @Autowired
    private FlightDateService flightDateService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @FXML
    private BorderPane bookingPane;
    @FXML
    private BorderPane dashboardPane;
    @FXML
    private BorderPane summaryPane;
    @FXML
    private BorderPane loginPane;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TableView<Flight> tableView;
    @FXML
    private ComboBox<String> fromLocationOption;
    @FXML
    private ComboBox<String> toLocationOption;
    @FXML
    private ComboBox<String> flightTypeOption;
    @FXML
    private Button bookButton;
    @FXML
    private Button downloadPdf;
    @FXML
    private DatePicker departDate;
    @FXML
    private DatePicker returnDate;
    @FXML
    private Label originLabel;
    @FXML
    private Label destinationLabel;
    @FXML
    private Label departDateLabel;
    @FXML
    private Label returnDateLabel;
    @FXML
    private Label flightTypeLabel;
    @FXML
    private Label flightSlotLabel;
    @FXML
    private Label flightPriceLabel;
    @FXML
    public void initialize() {
        initializeTable();
        locationHandler();
        flightDateHandler();
        flightTypeHandler();
        handlePaneVisibility();

    }
    @FXML
    private void logoutNav(){
        loginPane.setVisible(true);
        bookingPane.setVisible(false);
        dashboardPane.setVisible(false);
        summaryPane.setVisible(false);
        usernameField.clear();
        passwordField.clear();
        usernameField.setStyle(null);
        passwordField.setStyle(null);
    }
//    @FXML
//    private void backToBooking(){
//        bookingPane.setStyle(null);
//        bookingPane.setVisible(true);
//        dashboardPane.setVisible(false);
//        loginPane.setVisible(false);
//
//
//    }
    @FXML
    private void backToBooking() {
        // Reset styles and visibility
        bookingPane.setStyle(null);
        bookingPane.setVisible(true);
        dashboardPane.setVisible(false);
        loginPane.setVisible(false);

        // Additional logic for clearing fields or resetting other components
         usernameField.clear();
         passwordField.clear();
         usernameField.setStyle(null);
         passwordField.setStyle(null);
    }

    @FXML
    private void handleBookingButtonClick() {
        dashboardPane.setVisible(false);
        summaryPane.setVisible(true);
    }
    @FXML
    private void handleLogin() {
        loginService.handleLogin(usernameField, passwordField, bookingPane);
    }

    public void loginEnterButton(javafx.scene.input.KeyEvent event) {
        if (event.getCode().equals(javafx.scene.input.KeyCode.ENTER)) {
            loginService.handleLogin(usernameField, passwordField, bookingPane);
        }
    }
    @FXML
    public void setDownloadPdf(){
        pdfGeneratorService.pdfGenerator();
    }
    @FXML
    private void findFlightButtonClick() {
        loadFlightService.findFlightButtonClick(fromLocationOption, toLocationOption,
                formatDateMonthYear(departDate), formatDateMonthYear(returnDate), flightTypeOption, tableView);
        columnPropertyService.loadRecordCount(fromLocationOption.getValue(), toLocationOption.getValue(),
                formatDateMonthYear(departDate), formatDateMonthYear(returnDate), flightTypeOption.getValue(), tableView);
    }
    @FXML
    public void handleTableRowClick(MouseEvent event) {
        tableRowClickService.handleTableRowClick(event, tableView, bookButton,downloadPdf, bookingPane, dashboardPane, loginPane);
        tableRowClickService.populateFlightDetails(originLabel,destinationLabel,departDateLabel,returnDateLabel,flightTypeLabel,flightSlotLabel,flightPriceLabel);
    }
    private void initializeTable() {
        columnPropertyService.tableColumnProperties(tableView);
    }
    public void locationHandler() {
        locationService.initializeFromLocation(fromLocationOption);
        locationService.initializeToLocation(toLocationOption);
        locationService.fromLocationListener(fromLocationOption, toLocationOption);
        locationService.toLocationListener(fromLocationOption, toLocationOption);
    }
    private void flightDateHandler() {
        flightDateService.initializeDepartDate(departDate);
        flightDateService.initializeReturnDate(returnDate);
        flightDateService.departDateListener(departDate);
        flightDateService.returnDateListener(returnDate);
    }
    public void flightTypeHandler() {
        flightTypeService.initializeFlightTypeOptions(flightTypeOption);
        flightTypeService.flightTypeListener(flightTypeOption);
    }
    @FXML
    private void handlePaneVisibility() {
        bookingPane.setVisible(false);
        dashboardPane.setVisible(false);
        summaryPane.setVisible(false);
    }
}