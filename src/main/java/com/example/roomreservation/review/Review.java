package com.example.roomreservation.review;

import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String text;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private Integer rating;

    public ReviewDto asDto(){
        return ReviewDto.builder()
                .reviewId(reviewId)
                .user(user.asDto())
                .text(text)
                .hotelId(hotel.getHotelId())
                .rating(rating).build();
    }
}
