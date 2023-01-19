package com.example.roomreservation.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Opinie")
@RestController
@RequestMapping("/api/review/")
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
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
    ResponseEntity<List<ReviewDto>> getAllReviews(@PathVariable Integer hotelId) {
        return new ResponseEntity<>(reviewService.findAllHotelReviews(hotelId), HttpStatus.OK);
    }

    @PostMapping("/create-review")
    @Operation(summary = "Create review", responses = {
            @ApiResponse(description = "Create review success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
    })
    ResponseEntity createReview(@RequestBody ReviewDto reviewDto) {
            reviewService.createReview(reviewDto);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PatchMapping ("/update-review")
    @Operation(summary = "Update review", responses = {
            @ApiResponse(description = "Update review success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewDto.class)))
    })
    ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto response = reviewService.createReview(reviewDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-review/{reviewId}")
    @Operation(summary = "Delete review", responses = {
            @ApiResponse(description = "Delete review success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity deleteReview(@PathVariable Integer reviewId) {
        reviewService.deleteHotel(reviewId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }



}
