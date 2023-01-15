package com.example.roomreservation.config;

import com.example.roomreservation.hotel.Hotel;
import com.example.roomreservation.hotel.HotelRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSeed implements InitializingBean {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        setHotelData();
    }

    private void setHotelData(){
        hotelRepository.save(new Hotel(1,"Hotel Agat", "Spadochroniarzy", "15", "Lublin", "20-044", "698754448", "Super hotel dla studenta", 3));
        hotelRepository.save(new Hotel(2,"Hotel Szafir", "Partyzantów", "187", "Zamość", "22-400", "697885554", "Hotel blisko centrum otwarty dla zwiedzających", 4));
        hotelRepository.save(new Hotel(3,"Hotel Koral", "Magnoliowa", "48A", "Kraków", "31-069", "895748854", "Super ekskluzywny hotel", 5));
    }


}
