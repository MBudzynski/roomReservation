package com.example.roomreservation.config;

import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.hotel.HotelRepository;
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


    @Override
    public void afterPropertiesSet() throws Exception {
        setHotelData();
        setUserData();
    }

    private void setHotelData(){
        hotelRepository.save(new Hotel(null,"Hotel Agat", "Spadochroniarzy", "15", "Lublin", "20-044", "698754448", "Super hotel dla studenta", 3));
        hotelRepository.save(new Hotel(null,"Hotel Szafir", "Partyzantów", "187", "Zamość", "22-400", "697885554", "Hotel blisko centrum otwarty dla zwiedzających", 4));
        hotelRepository.save(new Hotel(null,"Hotel Koral", "Magnoliowa", "48A", "Kraków", "31-069", "895748854", "Super ekskluzywny hotel", 5));
    }

    private void setUserData(){
        userRepository.save(new User(null, "Jan", "Kowalski", "999999999", "AWT 458752", "Pracownik"));
        userRepository.save(new User(null, "Iwona", "Bednarek", "888888888", "SRD 584233", "Klient"));
        userRepository.save(new User(null, "Tomasz", "Karwert", "777777777", "FKE 5725413", "Właściciel"));
        userRepository.save(new User(null, "Oliwia", "Krakowiak", "6666666666", "SOP 583453", "Klient"));
    }


}
