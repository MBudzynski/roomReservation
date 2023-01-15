package com.example.roomreservation.room;

import com.example.roomreservation.items.Hotel;
import com.example.roomreservation.items.HotelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private HotelRepository hotelRepository;

    public RoomController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/getHotels")
    List<Hotel> registerForm() {
        return hotelRepository.findAll();
    }


}
