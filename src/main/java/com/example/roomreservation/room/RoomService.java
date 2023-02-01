package com.example.roomreservation.room;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;

    public List<RoomDto> findHotelAllRooms(Integer hotelId) {
        return roomRepository.findHotelAllRooms(hotelId).stream().map(Room::asDto).collect(Collectors.toList());
    }

    public RoomDto createRoom(RoomDto roomDto) {
        return roomRepository.save(roomDto.asEntity()).asDto();
    }

    public void deleteRoom(Integer roomId) {
        roomRepository.deleteById(roomId);
    }
}
