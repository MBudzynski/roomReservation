package com.example.roomreservation.hotel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/")
@Tag(name = "Hotel")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/get-hotels")
    @Operation(summary = "Get all hotels", responses = {
            @ApiResponse(description = "Get hotles sucess", responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Hotel.class)))
    })
    List<Hotel> registerForm() {
        return hotelRepository.findAll();
    }


}
