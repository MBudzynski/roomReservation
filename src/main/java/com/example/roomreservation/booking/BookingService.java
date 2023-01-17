package com.example.roomreservation.booking;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;


    public List<BookingDto> findAllHotelBookings(Integer hotelId) {
        return bookingRepository.findAllHotelReview(hotelId).stream().map(Booking::asDto).collect(Collectors.toList());
    }

    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingRepository.save(bookingDto.asEntity()).asDto();
    }

    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
