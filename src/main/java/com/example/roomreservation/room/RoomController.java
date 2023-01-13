package com.example.roomreservation.room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @GetMapping("/getGreetings")
    String registerForm() {
        return "Cześć tu rezerwacja pokoi";
    }
}
