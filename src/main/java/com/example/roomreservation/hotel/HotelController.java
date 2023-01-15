package com.example.roomreservation.hotel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/")
@Tag(name = "Hotel")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/get-hotels")
    @Operation(summary = "Get all hotels", responses = {
            @ApiResponse(description = "Get hotels success", responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class)))
    })
    ResponseEntity<List<Hotel>> registerForm() {
        return new ResponseEntity<>(hotelService.findAllHotels(), HttpStatus.OK);
    }

    @PostMapping("/create-hotel")
    @Operation(summary = "Create hotel", responses = {
            @ApiResponse(description = "Create hotel success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class)))
    })
    ResponseEntity createHotel(@RequestBody Hotel hotel) {
        hotelService.createHotel(hotel);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-hotel/{hotelId}")
    @Operation(summary = "Delete hotel", responses = {
            @ApiResponse(description = "Delete hotel success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity createHotel(@PathVariable Integer hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }

    @PatchMapping ("/update-hotel")
    @Operation(summary = "Update hotel", responses = {
            @ApiResponse(description = "Update hotel success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class)))
    })
    ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        Hotel response = hotelService.createHotel(hotel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
