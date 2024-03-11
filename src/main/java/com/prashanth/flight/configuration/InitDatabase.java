package com.prashanth.flight.configuration;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.model.LoginCredentials;
import com.prashanth.flight.repository.FlightRepository;
import com.prashanth.flight.repository.LoginRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import static com.prashanth.flight.constant.CommonConstant.*;
import static com.prashanth.flight.util.CommonUtil.*;
import static com.prashanth.flight.util.CommonUtil.randomTimeGenerator;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitDatabase {

    private FlightRepository flightRepository;
    private LoginRepository loginRepository;


    @Bean
    CommandLineRunner initDatabases() {
        return args -> {
            populateLogin();
//            generateAllCombinations();
            log.info("Database Initialized");
        };
    }

    public void populateLogin() {
        LoginCredentials loginCredentials = new LoginCredentials();
        loginCredentials.setUsername("abc");
        loginCredentials.setPassword("abc");
        loginCredentials.setName("PRASHANTH");
        loginRepository.save(loginCredentials);
    }


    public void generateAllCombinations() {
        for (String airline : AIRLINES) {
            Set<String> usedDestinations = new HashSet<>();

            for (String origin : ORIGINS) {
                for (String destination : ORIGINS) {
                    if (!origin.equals(destination) && !usedDestinations.contains(destination)) {
                        for (String flightType : FLIGHT_TYPES) {
                            // Generate and store flight data
                            generateAndStoreFlightData(airline, origin, destination, flightType);
                        }
                        // Update usedDestinations set after processing one destination
                        usedDestinations.add(destination);
                    }
                }
                // Clear usedDestinations set after processing one origin
                usedDestinations.clear();
            }
        }
    }


    private void generateAndStoreFlightData(String airline, String origin, String destination, String flightType) {
        LocalDate todayDate = LocalDate.now();

        for (int departDay = 0; departDay <= 10; departDay++) {
            LocalDate currentDepartDate = todayDate.plusDays(departDay);

            for (int returnDay = 1; returnDay <= 10; returnDay++) {
                LocalDate currentReturnDate = currentDepartDate.plusDays(returnDay);

                if (!currentReturnDate.isBefore(currentDepartDate)) {
                    String uniqueId = String.valueOf(uniqueIdCounter++);
                    String formattedDepartDate = currentDepartDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    String formattedReturnDate = currentReturnDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    String combinationKey = airline + "-" + origin + "-" + destination + "-" + flightType + "-" +
                            formattedDepartDate + "-" + formattedReturnDate;

                    if (!USED_COMBINATIONS.contains(combinationKey)) {
                        Flight flight = new Flight();
                        flight.setId(uniqueId);
                        flight.setAirline(airline);
                        flight.setOrigin(origin);
                        flight.setDestination(destination);
                        flight.setPrice(randomPriceGenerator());
                        flight.setFlightSlot(randomTimeGenerator() + "-" + randomTimeGenerator());
                        flight.setFlightType(flightType);
                        flight.setDepartDate(formattedDepartDate);
                        flight.setReturnDate(formattedReturnDate);
                        flightRepository.save(flight);
                        USED_COMBINATIONS.add(combinationKey);
                    }
                }
            }
        }
    }


}
