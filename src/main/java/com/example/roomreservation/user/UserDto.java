package com.example.roomreservation.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

     private Integer userId;
     private String firstName;
     private String lastName;
     private String phoneNumber;
     private String documentNumber;
     private String accountType;
     private String email;
     private String password;

}
