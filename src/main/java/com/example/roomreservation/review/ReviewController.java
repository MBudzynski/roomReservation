package com.example.roomreservation.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review/")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/get-hotel-reviews/{hotelId}")
    @Operation(summary = "Get hotel reviews", responses = {
            @ApiResponse(description = "Get hotel reviews success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewDto.class)))
    })
    ResponseEntity<List<ReviewDto>> registerForm(@PathVariable Integer hotelId) {
        return new ResponseEntity<>(reviewService.findAllHotelReviews(hotelId), HttpStatus.OK);
    }

    @PostMapping("/create-review")
    @Operation(summary = "Create review", responses = {
            @ApiResponse(description = "Create review success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
    })
    ResponseEntity createUser(@RequestBody ReviewDto reviewDto) {
            reviewService.createReview(reviewDto);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PatchMapping ("/update-review")
    @Operation(summary = "Update review", responses = {
            @ApiResponse(description = "Update review success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewDto.class)))
    })
    ResponseEntity<ReviewDto> updateHotel(@RequestBody ReviewDto reviewDto) {
        ReviewDto response = reviewService.createReview(reviewDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-review/{reviewId}")
    @Operation(summary = "Delete review", responses = {
            @ApiResponse(description = "Delete review success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity deleteHotel(@PathVariable Integer reviewId) {
        reviewService.deleteHotel(reviewId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }



}
