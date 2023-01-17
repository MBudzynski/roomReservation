package com.example.roomreservation.room;

import com.example.roomreservation.hotel.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private Integer roomId;
    private Integer hotelId;
    private String roomNumber;
    private BigDecimal price;
    private String numberPerson;
    private String description;
    private Boolean available;
    private String quality;
    private Integer floor;

    public Room asEntity(){
        return new Room(roomId,
                roomNumber,
                price,
                numberPerson,
                description,
                available,
                quality,
                floor,
                new Hotel(hotelId));
    }
}
