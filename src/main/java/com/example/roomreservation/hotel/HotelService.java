package com.example.roomreservation.hotel;

import com.example.roomreservation.exception.NotFoundException;
import com.example.roomreservation.review.Review;
import com.example.roomreservation.review.ReviewDto;
import com.example.roomreservation.review.ReviewRepository;
import com.example.roomreservation.room.Room;
import com.example.roomreservation.room.RoomDto;
import com.example.roomreservation.room.RoomRepository;
import com.example.roomreservation.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private ReviewRepository reviewRepository;
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public HotelService(HotelRepository hotelRepository,
                        ReviewRepository reviewRepository,
                        RoomRepository roomRepository,
                        UserRepository userRepository) {
        this.hotelRepository = hotelRepository;
        this.reviewRepository = reviewRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
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

    public HotelDataDto findHotel(Integer hotelId) throws NotFoundException {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if(hotel.isPresent()){
            List<RoomDto> rooms = roomRepository.findHotelAllRooms(hotelId).stream().map(Room::asDto).collect(Collectors.toList());
            List<ReviewDto> reviews = reviewRepository.findAllHotelReview(hotelId).stream().map(Review::asDto).collect(Collectors.toList());
            HotelDataDto hotelDataDto = hotel.get().asHotelDataDto();
            hotelDataDto.setReviews(reviews);
            hotelDataDto.setRooms(rooms);
            hotelDataDto.getReviews().stream().forEach(reviewDto -> {
                reviewDto.setUser(userRepository.findById(reviewDto.getUser().getUserId()).get().asDto());
            });
            return hotelDataDto;
        } else {
            throw new NotFoundException("Hotel not exist");
        }
    }
}
