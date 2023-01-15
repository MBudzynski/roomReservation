package com.example.roomreservation.hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
