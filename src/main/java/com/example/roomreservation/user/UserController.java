package com.example.roomreservation.user;

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
@Tag(name = "Użytkownik")
@RequestMapping("/api/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-users")
    @Operation(summary = "Get all users", responses = {
            @ApiResponse(description = "Get all users success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    })
    ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create-user")
    @Operation(summary = "Create user", responses = {
            @ApiResponse(description = "Create user success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    })
    ResponseEntity createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-user/{userId}")
    @Operation(summary = "Delete user", responses = {
            @ApiResponse(description = "Delete user success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity createHotel(@PathVariable Integer userId) {
        userService.deleteHotel(userId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }

    @PatchMapping ("/update-user")
    @Operation(summary = "Update user", responses = {
            @ApiResponse(description = "Update user success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    })
    ResponseEntity<User> updateHotel(@RequestBody User user) {
        User response = userService.createUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
