package com.example.roomreservation.hotel;

import com.example.roomreservation.exception.NotFoundException;
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
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
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
    ResponseEntity<List<HotelDto>> getAllHotels() {
        return new ResponseEntity<>(hotelService.findAllHotels(), HttpStatus.OK);
    }

    @GetMapping("/get-hotel/{hotelId}")
    @Operation(summary = "Get hotel", responses = {
            @ApiResponse(description = "Get hotel success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = HotelDataDto.class))),
            @ApiResponse(description = "Hotel not exist", responseCode = "400",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    ResponseEntity getHotel(@PathVariable Integer hotelId) {
        try {
            return new ResponseEntity<>(hotelService.findHotel(hotelId), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))),
            @ApiResponse(description = "Hotel not exist", responseCode = "400",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    ResponseEntity deleteHotel(@PathVariable Integer hotelId) {
        try {
            hotelService.deleteHotel(hotelId);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @PatchMapping("/update-hotel")
    @Operation(summary = "Update hotel", responses = {
            @ApiResponse(description = "Update hotel success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class)))
    })
    ResponseEntity<HotelDto> updateHotel(@RequestBody Hotel hotel) {
        HotelDto response = hotelService.createHotel(hotel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
