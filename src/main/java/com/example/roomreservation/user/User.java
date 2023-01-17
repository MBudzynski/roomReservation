package com.example.roomreservation.user;

import com.example.roomreservation.review.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String documentNumber;
    private String accountType;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Review> review = new ArrayList<>();

    public User(Integer userId) {
        this.userId = userId;
    }

    public UserDto asDto(){
        return UserDto.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .documentNumber(documentNumber)
                .accountType(accountType)
                .email(email)
                .password(password)
                .build();
    }

}
