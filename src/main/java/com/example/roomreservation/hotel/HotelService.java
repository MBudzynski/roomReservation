package com.example.roomreservation.hotel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }

}
