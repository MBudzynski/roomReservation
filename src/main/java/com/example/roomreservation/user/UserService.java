package com.example.roomreservation.user;

import com.example.roomreservation.exception.EmailException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public User createUser(User user) throws EmailException{
        if(userRepository.existsByEmail(user.getEmail())){
          throw new EmailException("Address email already exist");
        }
        return userRepository.save(user);
    }

    public void deleteHotel(Integer userId) {
        userRepository.deleteById(userId);
    }
}
