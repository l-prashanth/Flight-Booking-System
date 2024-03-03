package com.prashanth.flight.repository;

import com.prashanth.flight.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
