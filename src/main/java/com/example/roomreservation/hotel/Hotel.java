package com.example.roomreservation.hotel;

import com.example.roomreservation.review.Review;
import com.example.roomreservation.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    private String name;
    private String street;
    private String houseNumber;
    private String city;
    private String postCode;
    private String phoneNumber;
    private String description;
    private Integer standard;
    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();


    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Room> rooms;

    public Hotel(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public HotelDto asDto(){
       return new HotelDto.HotelDtoBuilder()
               .hotelId(hotelId)
               .name(name)
               .street(street)
               .houseNumber(houseNumber)
               .city(city)
               .postCode(postCode)
               .phoneNumber(phoneNumber)
               .description(description)
               .standard(standard)
               .build();
    }
}
