package com.example.roomreservation.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM Review r WHERE r.hotel_id = :hotelId "
            , nativeQuery = true)
    List<Review> findAllHotelReview(Integer hotelId);

}
