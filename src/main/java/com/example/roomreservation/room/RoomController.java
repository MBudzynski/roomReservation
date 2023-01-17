package com.example.roomreservation.room;

import com.example.roomreservation.review.ReviewDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pokoje")
@RestController
@RequestMapping("/api/room/")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/get-hotel-rooms/{hotelId}")
    @Operation(summary = "Get hotel rooms", responses = {
            @ApiResponse(description = "Get hotel rooms success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewDto.class)))
    })
    ResponseEntity<List<RoomDto>> getRooms(@PathVariable Integer hotelId) {
        return new ResponseEntity<>(roomService.findAllHotelReviews(hotelId), HttpStatus.OK);
    }

    @PostMapping("/create-room")
    @Operation(summary = "Create room", responses = {
            @ApiResponse(description = "Create room success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
    })
    ResponseEntity createRoom(@RequestBody RoomDto roomDto) {
        roomService.createRoom(roomDto);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PatchMapping ("/update-room")
    @Operation(summary = "Update room", responses = {
            @ApiResponse(description = "Update room success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoomDto.class)))
    })
    ResponseEntity<RoomDto> updateRoom(@RequestBody
                                          RoomDto roomDto) {
        RoomDto response = roomService.createRoom(roomDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-room/{roomId}")
    @Operation(summary = "Delete room", responses = {
            @ApiResponse(description = "Delete room success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity deleteRoom(@PathVariable Integer roomId) {
        roomService.deleteHotel(roomId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }
}
