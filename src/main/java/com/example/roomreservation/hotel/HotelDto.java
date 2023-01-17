package com.example.roomreservation.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private Integer hotelId;
    private String name;
    private String street;
    private String houseNumber;
    private String city;
    private String postCode;
    private String phoneNumber;
    private String description;
    private Integer standard;
}
