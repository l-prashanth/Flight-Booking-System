package com.prashanth.flight.service;

import com.prashanth.flight.model.Booking;
import com.prashanth.flight.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;



    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public void saveBooking(Booking booking) {
        // Perform any additional logic before saving, if needed
        bookingRepository.save(booking);
    }

}
