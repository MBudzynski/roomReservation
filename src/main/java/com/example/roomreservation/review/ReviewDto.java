package com.example.roomreservation.review;

import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Integer reviewId;
    private Integer userId;
    private String text;
    private Integer hotelId;
    private Integer rating;

    public Review asEntity(){
        return new Review(reviewId,
                new User(userId),
                text,
                new Hotel(hotelId),
                rating);
    }


}
