package com.example.roomreservation.config;

import com.example.roomreservation.booking.Booking;
import com.example.roomreservation.booking.BookingRepository;
import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.hotel.HotelRepository;
import com.example.roomreservation.review.Review;
import com.example.roomreservation.review.ReviewRepository;
import com.example.roomreservation.room.Room;
import com.example.roomreservation.room.RoomRepository;
import com.example.roomreservation.user.User;
import com.example.roomreservation.user.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DataSeed implements InitializingBean {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        setUserData();
        setHotelData();
        setReviewData();
        setRoomData();
        setBookingData();
    }

    private void setHotelData(){
        hotelRepository.save(new Hotel(null,"Hotel Agat", "Spadochroniarzy", "15", "Lublin", "20-044", "698754448", "Super hotel dla studenta", 3, null, null, 3));
        hotelRepository.save(new Hotel(null,"Hotel Szafir", "Partyzantów", "187", "Zamość", "22-400", "697885554", "Hotel blisko centrum otwarty dla zwiedzających", 4, null, null, 3));
        hotelRepository.save(new Hotel(null,"Hotel Koral", "Magnoliowa", "48A", "Kraków", "31-069", "895748854", "Super ekskluzywny hotel", 5, null,null, 3));
    }

    private void setUserData(){
        userRepository.save(new User(null, "Jan", "Kowalski", "999999999", "AWT 458752", "Pracownik", "zaqwsx123@o2.pl", "H@slo123", null));
        userRepository.save(new User(null, "Iwona", "Bednarek", "888888888", "SRD 584233", "Klient", "zaqws123@o2.pl", "H@slo234", null));
        userRepository.save(new User(null, "Tomasz", "Karwert", "777777777", "FKE 5725413", "Właściciel", "zaqw123@o2.pl", "H@slo345", null));
        userRepository.save(new User(null, "Oliwia", "Krakowiak", "6666666666", "SOP 583453", "Klient", "zaq123@o2.pl", "H@slo456",null));
    }

    private void setReviewData(){
        reviewRepository.save(new Review(1, new User(1) , "Opinia Opinia Opinia 1", new Hotel(1) ,5));
        reviewRepository.save(new Review(2, new User(2) , "Opinia Opinia Opinia 2", new Hotel(2) ,4));
        reviewRepository.save(new Review(3, new User(3) , "Opinia Opinia Opinia 3", new Hotel(3) ,3));
        reviewRepository.save(new Review(4, new User(1) , "Opinia Opinia Opinia 4", new Hotel(1) ,1));
    }

    private void setRoomData(){
        roomRepository.save(new Room(1, "A100", new BigDecimal(300), "1 - 2", "Opis opis1", true, "A", 1, new Hotel(1)));
        roomRepository.save(new Room(2, "A200", new BigDecimal(250), "1 - 2", "Opis opis2", true, "C", 2, new Hotel(2)));
        roomRepository.save(new Room(3, "A300", new BigDecimal(400), "1 - 2", "Opis opis3", true, "B", 3, new Hotel(3)));
        roomRepository.save(new Room(4, "A400", new BigDecimal(100), "1 - 2", "Opis opis4", true, "F", 4, new Hotel(1)));
    }

    private void setBookingData(){
        bookingRepository.save(new Booking(1, new User(1), LocalDate.now(), LocalDate.now().plusDays(3),new Room(1), new Hotel(1), false, LocalDateTime.now()));
        bookingRepository.save(new Booking(2, new User(2), LocalDate.now(), LocalDate.now().plusDays(4),new Room(2), new Hotel(2), false, LocalDateTime.now()));
        bookingRepository.save(new Booking(3, new User(3), LocalDate.now(), LocalDate.now().plusDays(5),new Room(3), new Hotel(3), false, LocalDateTime.now()));
    }
}
