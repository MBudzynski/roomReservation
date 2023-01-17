package com.example.roomreservation.room;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;

    public List<RoomDto> findAllHotelReviews(Integer hotelId) {
        return roomRepository.findAllHotelReview(hotelId).stream().map(Room::asDto).collect(Collectors.toList());
    }

    public RoomDto createRoom(RoomDto roomDto) {
        return roomRepository.save(roomDto.asEntity()).asDto();
    }

    public void deleteHotel(Integer roomId) {
        roomRepository.deleteById(roomId);
    }
}
