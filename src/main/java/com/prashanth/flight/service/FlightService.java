package com.prashanth.flight.service;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
//    public List<Flight> saveFlights() {
//        Flight flight = new Flight();
//        flight.setFlightNumber(1);
//        return Collections.singletonList(flightRepository.save(flight));
//    }

    // Other flight-related methods
}
