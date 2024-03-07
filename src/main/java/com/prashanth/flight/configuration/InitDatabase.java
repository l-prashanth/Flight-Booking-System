package com.prashanth.flight.configuration;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.prashanth.flight.constant.CommonConstant.*;
import static com.prashanth.flight.constant.CommonConstant.FIRST_CLASS;
import static com.prashanth.flight.util.CommonUtil.*;
import static com.prashanth.flight.util.CommonUtil.randomTimeGenerator;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitDatabase {

    private FlightRepository flightRepository;

    @Bean
    CommandLineRunner initDatabases(){
        return args -> {
            flightDataOnModification();
//            generateAllCombinations();
            log.info("Database Initialized");
        };
    }
    private static int uniqueIdCounter = 1;

    private void flightDataOnModification() {
        LocalDate startDate = LocalDate.now();

        for (int i = 0; i < 10; i++) {
            Flight flight = new Flight();
            int uniqueId = uniqueIdCounter++; // Implement a thread-safe ID generation method
            flight.setId(String.valueOf(uniqueId));

            // Fetch data from the repository based on uniqueId (adjust this logic based on your repository structure)
            Flight existingFlight = flightRepository.findById(String.valueOf(uniqueId)).orElse(new Flight());

            flight.setAirline(existingFlight.getAirline());
            flight.setOrigin(existingFlight.getOrigin());
            flight.setDestination(existingFlight.getDestination());
            flight.setPrice(existingFlight.getPrice());
            flight.setFlightSlot(existingFlight.getFlightSlot());
            flight.setFlightType(existingFlight.getFlightType());
            flight.setDepartDate(startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            flight.setReturnDate(startDate.plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            startDate = startDate.plusDays(1);

            flightRepository.save(flight);
        }
    }

    public void generateAllCombinations() {
        String[] origins = {DELHI, MUMBAI, HYDERABAD, BANGALORE, CHENNAI};
        String[] flightTypes = {ECONOMY, ECONOMY_PRO, BUSINESS, FIRST_CLASS};
        String[] airlines = {INDIGO, SPICEJET, AIR_INDIA, AKASA_AIR};

        for (String origin : origins) {
            for (String destination : origins) {
                if (!origin.equals(destination)) {
                    for (String flightType : flightTypes) {
                        for (String airline : airlines) {
                            LocalDate startDate = LocalDate.now();
                            for (int i = 0; i < 10; i++) {
                                String uniqueId = String.valueOf(uniqueIdCounter++);
                                String departDate = startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                String returnDate = startDate.plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                                flightData(uniqueId, airline, origin, destination, randomPriceGenerator(),
                                        randomTimeGenerator() + "-" + randomTimeGenerator(), flightType, departDate, returnDate);
                                startDate = startDate.plusDays(1);
                            }
                        }
                    }
                }
            }
        }
    }

    // Replace these methods with your actual implementation
    private void flightData(String id, String airline, String origin, String destination, int price,
                            String flightSlot, String flightType, String departDate, String returnDate) {
        Flight flight = new Flight();
        flight.setId(id);
        flight.setAirline(airline);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setPrice(price);
        flight.setFlightSlot(flightSlot);
        flight.setFlightType(flightType);
        flight.setDepartDate(departDate);
        flight.setReturnDate(returnDate);
        flightRepository.save(flight);
    }

    // Method with all possible combinations
//    public void generateAllCombinations() {
//
//        String[] origins = {DELHI, MUMBAI, HYDERABAD, BANGALORE, CHENNAI};
//        String[] flightTypes = {ECONOMY, ECONOMY_PRO, BUSINESS, FIRST_CLASS};
//        String[] airlines = {INDIGO, SPICEJET, AIR_INDIA, AKASA_AIR};
//
//        for (String origin : origins) {
//            for (String destination : origins) {
//                if (!origin.equals(destination)) {
//                    for (String flightType : flightTypes) {
//                        for (String airline : airlines) {
//                            String uniqueId = "" + (uniqueIdCounter++);
//                            String departDate = dateHandler("Depart");
//                            String returnDate = dateHandler("Return");
//
//                            flightData(uniqueId, airline, origin, destination, randomPriceGenerator(),
//                                    randomTimeGenerator() + "-" + randomTimeGenerator(), flightType, departDate, returnDate);
//                        }
//                    }
//                }
//            }
//        }
//    }


}
