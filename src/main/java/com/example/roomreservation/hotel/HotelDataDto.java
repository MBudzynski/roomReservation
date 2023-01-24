package com.example.roomreservation.hotel;

import com.example.roomreservation.review.ReviewDto;
import com.example.roomreservation.room.RoomDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDataDto {

    private Integer hotelId;
    private String name;
    private String street;
    private String houseNumber;
    private String city;
    private String postCode;
    private String phoneNumber;
    private String description;
    private Integer standard;
    private List<RoomDto> rooms;
    private List<ReviewDto> reviews;
}
