package com.example.roomreservation.booking;

import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.room.Room;
import com.example.roomreservation.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Integer bookingId;
    private Integer userId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer roomId;
    private Integer hotelId;
    private Boolean confirmed;
    private LocalDateTime created;

    public Booking asEntity(){
        return new Booking(bookingId,
                new User(userId),
                fromDate,
                toDate,
                new Room(roomId),
                new Hotel(hotelId),
                confirmed,
                created);
    }

}
