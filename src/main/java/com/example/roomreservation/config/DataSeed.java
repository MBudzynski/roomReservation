package com.example.roomreservation.config;

import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.hotel.HotelRepository;
import com.example.roomreservation.review.Review;
import com.example.roomreservation.review.ReviewRepository;
import com.example.roomreservation.user.User;
import com.example.roomreservation.user.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSeed implements InitializingBean {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        setHotelData();
        setUserData();
        setReviewData();
    }

    private void setHotelData(){
        hotelRepository.save(new Hotel(null,"Hotel Agat", "Spadochroniarzy", "15", "Lublin", "20-044", "698754448", "Super hotel dla studenta", 3, null));
        hotelRepository.save(new Hotel(null,"Hotel Szafir", "Partyzantów", "187", "Zamość", "22-400", "697885554", "Hotel blisko centrum otwarty dla zwiedzających", 4, null));
        hotelRepository.save(new Hotel(null,"Hotel Koral", "Magnoliowa", "48A", "Kraków", "31-069", "895748854", "Super ekskluzywny hotel", 5, null));
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


}
