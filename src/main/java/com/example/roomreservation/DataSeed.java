package com.example.roomreservation;

import com.example.roomreservation.items.Hotel;
import com.example.roomreservation.items.HotelRepository;
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
        hotelRepository.save(new Hotel(1,"Hotel 1"));
        hotelRepository.save(new Hotel(2,"Hotel 2"));
        hotelRepository.save(new Hotel(3,"Hotel 3"));
    }


}
