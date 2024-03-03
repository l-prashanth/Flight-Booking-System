package com.prashanth.flight.repository;

import com.prashanth.flight.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {

    List<Flight> findByOriginAndDestination(String origin, String destination);
}
