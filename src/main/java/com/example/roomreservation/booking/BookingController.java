package com.example.roomreservation.booking;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rezerwacje")
@RestController
@RequestMapping("/api/booking/")
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/get-hotel-bookings/{hotelId}")
    @Operation(summary = "Get hotel bookings", responses = {
            @ApiResponse(description = "Get hotel bookings success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDto.class)))
    })
    ResponseEntity<List<BookingDto>> getBookingsByHotelId(@PathVariable Integer hotelId) {
        return new ResponseEntity<>(bookingService.findAllHotelBookings(hotelId), HttpStatus.OK);
    }

    @PostMapping("/create-booking")
    @Operation(summary = "Create booking", responses = {
            @ApiResponse(description = "Create booking success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
    })
    ResponseEntity createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PatchMapping ("/update-booking")
    @Operation(summary = "Update booking", responses = {
            @ApiResponse(description = "Update booking success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDto.class)))
    })
    ResponseEntity<BookingDto> updateBooking(@RequestBody
                                       BookingDto bookingDto) {
        BookingDto response = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-booking/{bookingId}")
    @Operation(summary = "Delete booking", responses = {
            @ApiResponse(description = "Delete booking success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity deleteBooking(@PathVariable Integer bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }
}
