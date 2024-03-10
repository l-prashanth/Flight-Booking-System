package com.prashanth.flight.service;

import com.prashanth.flight.model.LoginCredentials;
import com.prashanth.flight.model.SelectedTableRow;
import com.prashanth.flight.repository.LoginRepository;
import com.prashanth.flight.repository.SelectedTableRowRepository;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

import static com.prashanth.flight.constant.CommonConstant.FONT_PATH;
import static com.prashanth.flight.util.CommonUtil.isNotNullOrEmpty;

@Service
@AllArgsConstructor
public class PDFGeneratorService {
    SelectedTableRowRepository selectedTableRowRepository;
    LoginRepository loginRepository;


    @SneakyThrows
    public void pdfGenerator() {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                pdfElements(contentStream, document);
            }
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf"));
            File file = fileChooser.showSaveDialog(new Stage());
            if (isNotNullOrEmpty(file))
                document.save(file);
            System.out.println("PDF saved to: " + file.getAbsolutePath());
        }
    }

    @SneakyThrows
    private void pdfElements(PDPageContentStream contentStream, PDDocument document) {
        SelectedTableRow selectedTableRow = selectedTableRowRepository.findAll().get(0);
        LoginCredentials loginCredentials = loginRepository.findAll().get(0);
        String airline = selectedTableRow.getAirline();
        String origin = selectedTableRow.getOrigin();
        String destination = selectedTableRow.getDestination();
        double price = selectedTableRow.getPrice();
        String departDate = selectedTableRow.getDepartDate();
        String returnDate = selectedTableRow.getReturnDate();
        String flightSlot = selectedTableRow.getFlightSlot();
        String flightType = selectedTableRow.getFlightType();
        String name = loginCredentials.getName();

        contentStream.beginText();
        PDType0Font customFont = PDType0Font.load(document, new File(FONT_PATH));
        contentStream.setFont(customFont, 12);
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Name: " + name);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Airline: " + airline);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Origin: " + origin);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Destination: " + destination);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Price: " + price);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("DepartDate: " + departDate);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("ReturnDate: " + returnDate);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("FlightSlot: " + flightSlot);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("FlightType: " + flightType);
        contentStream.endText();
    }
}
