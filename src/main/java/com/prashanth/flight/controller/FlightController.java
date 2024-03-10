package com.prashanth.flight.controller;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.model.SelectedTableRow;
import com.prashanth.flight.repository.FlightRepository;
import com.prashanth.flight.repository.SelectedTableRowRepository;
import com.prashanth.flight.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private SelectedTableRowRepository selectedTableRowRepository;
    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @FXML
    private BorderPane bookingPane;
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
    private GridPane dashboardPane;
    @FXML
    private BorderPane loginPane;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

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
    private BorderPane summaryPane;
    @FXML
    private Button downloadPdf;

    @FXML
    private void handleLogin() {
        loginService.handleLogin(usernameField, passwordField, bookingPane);

    }

    public void handleKeyPress(javafx.scene.input.KeyEvent event) {
        if (event.getCode().equals(javafx.scene.input.KeyCode.ENTER)) {
            loginService.handleLogin(usernameField, passwordField, bookingPane);
        }
    }
    @FXML
    public void setDownloadPdf(){
        pdfGeneratorService.pdfGenerator();
    }

    @FXML
    public void initialize() {
        initializeTable();
        locationHandler();
        flightDateHandler();
        flightTypeHandler();
        bookingPane.setVisible(false);
        dashboardPane.setVisible(false);
        summaryPane.setVisible(false);
        populate();
    }

    public void populate() {
        SelectedTableRow flightDetails = selectedTableRowRepository.findAll().get(0);
//
//        originLabel.setText(flightDetails.getOrigin());
//        destinationLabel.setText(flightDetails.getDestination());
//        departDateLabel.setText(flightDetails.getDepartDate());
//        returnDateLabel.setText(flightDetails.getReturnDate());
//        flightTypeLabel.setText(flightDetails.getFlightType());

        originLabel.textProperty().bind(flightDetails.originProperty());
        destinationLabel.textProperty().bind(flightDetails.destinationProperty());
        departDateLabel.textProperty().bind(flightDetails.departDateProperty());
        returnDateLabel.textProperty().bind(flightDetails.returnDateProperty());
        flightTypeLabel.textProperty().bind(flightDetails.flightTypeProperty());
//
//        if (dashboardPane != null) {
//            dashboardPane.setVisible(true);  // Adjust visibility as needed
//        } else {
//            System.err.println("dashboardPane is null. Check your FXML file and @FXML annotation.");
//        }

    }


    public void locationHandler() {
        locationService.initializeFromLocation(fromLocationOption);
        locationService.initializeToLocation(toLocationOption);
        locationService.fromLocationListener(fromLocationOption, toLocationOption);
        locationService.toLocationListener(fromLocationOption, toLocationOption);
    }

    public void flightTypeHandler() {
        flightTypeService.initializeFlightTypeOptions(flightTypeOption);
        flightTypeService.flightTypeListener(flightTypeOption);
    }

    private void flightDateHandler() {
        flightDateService.initializeDepartDate(departDate);
        flightDateService.initializeReturnDate(returnDate);
        flightDateService.departDateListener(departDate);
        flightDateService.returnDateListener(returnDate);
    }
//    public void departDateHandler(){
//        departDateService.initializeDepartDate(departDate);
//        departDateService.departDateListener(departDate);
//    }

    private void initializeTable() {
        columnPropertyService.tableColumnProperties(tableView);
    }

    @FXML
    private void findFlightButtonClick() {
        loadFlightService.findFlightButtonClick(fromLocationOption, toLocationOption,
                formatDateMonthYear(departDate), formatDateMonthYear(returnDate), flightTypeOption, tableView);
        columnPropertyService.loadRecordCount(fromLocationOption.getValue(), toLocationOption.getValue(),
                formatDateMonthYear(departDate), formatDateMonthYear(returnDate), flightTypeOption.getValue(), tableView);
    }

    @FXML
    private void createDashboard() {

    }

    @FXML
    public void handleTableRowClick(MouseEvent event) {
        tableRowClickService.handleTableRowClick(event, tableView, bookButton,downloadPdf, bookingPane, dashboardPane, loginPane);
    }

    @FXML
    private void handleBookingButtonClick() {
        dashboardPane.setVisible(false);
        summaryPane.setVisible(true);

    }


}