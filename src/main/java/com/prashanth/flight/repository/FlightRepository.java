package com.prashanth.flight.repository;

import com.prashanth.flight.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByOriginAndDestinationAndDepartDateAndReturnDateAndFlightType(
            String origin, String destination, String departDate, String returnDate, String flightType
    );
}
