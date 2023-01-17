package com.example.roomreservation.hotel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> findAllHotels(){
        return hotelRepository.findAll().stream().map(Hotel::asDto).collect(Collectors.toList());
    }

    public HotelDto createHotel(Hotel hotel) {
        return hotelRepository.save(hotel).asDto();
    }

    public void deleteHotel(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }

}
