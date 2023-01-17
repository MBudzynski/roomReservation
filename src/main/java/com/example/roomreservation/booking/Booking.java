package com.example.roomreservation.booking;


import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.room.Room;
import com.example.roomreservation.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate fromDate;
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private Boolean confirmed;
    private LocalDateTime created;

    public BookingDto asDto(){
        return new BookingDto(bookingId,
                user.getUserId(),
                fromDate,
                toDate,
                room.getRoomId(),
                hotel.getHotelId(),
                confirmed,
                created);
    }
}
