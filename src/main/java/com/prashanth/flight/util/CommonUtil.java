package com.prashanth.flight.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.prashanth.flight.constant.CommonConstant.*;

@Component
public class CommonUtil {
    public static boolean isNullOrEmpty(Object... objects) {
        for (Object o : objects) {
            if (o == null || o == "") {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(Object... objects) {
        for (Object o : objects) {
            if (o instanceof Number number) {
                double numericValue = number.doubleValue();
                if (numericValue == 0) {
                    return false;
                }
            }
            if (o == null || o.equals("")) {
                return false;
            }
        }
        return true;
    }

    public static List<String> locationList() {
        return Arrays.asList(DELHI, MUMBAI, HYDERABAD, BANGALORE, CHENNAI);
    }

    public static boolean mouseClickEvent(MouseEvent event) {

        return event.getClickCount() == 1;
    }

    public static ObservableList<String> fxLocationList() {
        return FXCollections.observableArrayList(locationList());
    }

    public static List<String> flightTypeList() {
        return Arrays.asList(ECONOMY, ECONOMY_PRO, BUSINESS, FIRST_CLASS);
    }

    public static ObservableList<String> fxFlightTypeList() {
        return FXCollections.observableArrayList(flightTypeList());
    }

    public static void dateUIFormatter(DatePicker datepicker) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        datepicker.setConverter(new StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                if (isNotNullOrEmpty(date)) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (isNotNullOrEmpty(string)) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }

    public static String formatDateMonthYear(DatePicker datePicker) {
        LocalDate selectedDepartDate = datePicker.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return selectedDepartDate.format(formatter);
    }

    public static final Random random = new Random();

    public static int randomPriceGenerator() {
        return random.nextInt(12001) + 3000;
    }

    public static String randomTimeGenerator() {
        int randomHours = random.nextInt(24);
        int randomMinutes = random.nextBoolean() ? 0 : 30;
        return String.format("%02d:%02d", randomHours, randomMinutes);
    }
    public static String dateHandler(String operation) {
        LocalDate startDate;
        LocalDate endDate;
        String[] dateArray;

        if (operation.equals("Depart")) {
            // Departure dates from today to today + 10
            startDate = LocalDate.now();
            endDate = startDate.plusDays(10);
            dateArray = new String[11];
        } else if (operation.equals("Return")) {
            // Return dates from tomorrow to tomorrow + 11
            startDate = LocalDate.now().plusDays(1);
            endDate = startDate.plusDays(11);
            dateArray = new String[12];
        } else {
            return ""; // Handle other cases as needed
        }

        int i = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            dateArray[i++] = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        String randomDate = dateArray[random.nextInt(dateArray.length)];
        System.out.println(operation + " Dates:");
        System.out.println(randomDate);
        return randomDate;
    }

}
