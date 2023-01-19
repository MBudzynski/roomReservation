package com.example.roomreservation.hotel;

import com.example.roomreservation.exception.NotFoundException;
import com.example.roomreservation.review.ReviewRepository;
import com.example.roomreservation.room.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private ReviewRepository reviewRepository;
    private RoomRepository roomRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> findAllHotels(){
        return hotelRepository.findAll().stream().map(Hotel::asDto).collect(Collectors.toList());
    }

    public HotelDto createHotel(Hotel hotel) {
        if(hotel.getHotelId() != null){
            Hotel entity = hotelRepository.findById(hotel.getHotelId()).get();
            hotel.setReviews(entity.getReviews());
            hotel.setRooms(entity.getRooms());
            return hotelRepository.save(hotel).asDto();
        } else {
            return hotelRepository.save(hotel).asDto();
        }

    }

    public void deleteHotel(Integer hotelId) throws NotFoundException {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if(hotel.isPresent()){
            reviewRepository.deleteAll(hotel.get().getReviews());
            roomRepository.deleteAll(hotel.get().getRooms());
            hotelRepository.deleteById(hotelId);
        } else {
            throw new NotFoundException("Hotel not exist");
        }
    }

}
