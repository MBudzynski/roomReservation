package com.example.roomreservation.review;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;

    public List<ReviewDto> findAllHotelReviews(Integer hotelId){
       return reviewRepository.findAllHotelReview(hotelId).stream().map(Review::asDto).collect(Collectors.toList());
    }

    public ReviewDto createReview(ReviewDto reviewDto) {
        return reviewRepository.save(reviewDto.asEntity()).asDto();
    }

    public void deleteHotel(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
