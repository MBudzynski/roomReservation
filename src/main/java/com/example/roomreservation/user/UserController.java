package com.example.roomreservation.user;

import com.example.roomreservation.exception.EmailException;
import com.example.roomreservation.exception.LoginException;
import com.example.roomreservation.exception.NotFoundException;
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
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class)))
    })
    ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/get-user/{userId}")
    @Operation(summary = "Get user by id", responses = {
            @ApiResponse(description = "Get user success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(description = "User not found", responseCode = "400",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    ResponseEntity findUserById(@PathVariable Integer userId) {
        try {
            return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
        } catch (NotFoundException e){
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/create-user")
    @Operation(summary = "Create user", responses = {
            @ApiResponse(description = "Create user success", responseCode = "201",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(description = "Email already exists", responseCode = "400",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    ResponseEntity createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } catch (EmailException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-user/{userId}")
    @Operation(summary = "Delete user", responses = {
            @ApiResponse(description = "Delete user success", responseCode = "202",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)))
    })
    ResponseEntity deleteUser(@PathVariable Integer userId) {
        userService.deleteHotel(userId);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }

    @PatchMapping ("/update-user")
    @Operation(summary = "Update user", responses = {
            @ApiResponse(description = "Update user success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(description = "Email already exists", responseCode = "400",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    ResponseEntity updateUser(@RequestBody User user) {
        UserDto response = null;
        try {
            response = userService.createUser(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmailException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login-user")
    @Operation(summary = "Login user", responses = {
            @ApiResponse(description = "Login user success", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(description = "Email or password is incorrect", responseCode = "400",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    ResponseEntity loginUser(@RequestBody Login login) {
        try {
            UserDto user = userService.findUserByEmailAndPassword(login);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (LoginException e) {
            return new ResponseEntity<>("Email or password is incorrect", HttpStatus.BAD_REQUEST);
        }
    }


}
