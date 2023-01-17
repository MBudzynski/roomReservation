package com.example.roomreservation.room;


import com.example.roomreservation.hotel.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomNumber;
    private BigDecimal price;
    private String numberPerson;
    private String description;
    private Boolean available;
    private String quality;
    private Integer floor;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotelId;

    public RoomDto asDto(){
        return RoomDto.builder()
                .roomId(roomId)
                .hotelId(hotelId.getHotelId())
                .roomNumber(roomNumber)
                .price(price)
                .numberPerson(numberPerson)
                .description(description)
                .available(available)
                .quality(quality)
                .floor(floor)
                .build();
    }
}
