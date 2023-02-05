package com.example.roomreservation.user;

import com.example.roomreservation.exception.EmailException;
import com.example.roomreservation.exception.LoginException;
import com.example.roomreservation.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return  userRepository.findAll().stream().map(User::asDto).collect(Collectors.toList());
    }

    public UserDto createUser(User user) throws EmailException{
        if(userRepository.existsByEmail(user.getEmail())){
          throw new EmailException("Address email already exist");
        }
        return userRepository.save(user).asDto();
    }

    public UserDto createUserWithoutCheckEmail(User user){
        return userRepository.save(user).asDto();
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public UserDto findUserByEmailAndPassword(Login login) throws LoginException {
       return userRepository.findByEmailAndPasword(login.getEmail(), login.getPassword()).orElseThrow(() -> new LoginException("Email or password is incorrect")).asDto();
    }

    public UserDto findUserById(Integer userId) throws NotFoundException {
       return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found")).asDto();
    }
}
