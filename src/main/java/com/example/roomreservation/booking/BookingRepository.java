package com.example.roomreservation.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT * FROM Booking b WHERE b.hotel_id = :hotelId "
            , nativeQuery = true)
    List<Booking> findAllHotelReview(Integer hotelId);
}
