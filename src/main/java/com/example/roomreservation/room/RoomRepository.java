package com.example.roomreservation.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "SELECT * FROM Room r WHERE r.hotel_id = :hotelId "
            , nativeQuery = true)
    List<Room> findHotelAllRooms(Integer hotelId);
}
