package com.example.roomreservation.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM user u where u.email = :email and u.password = :password ;", nativeQuery = true)
    Optional<User> findByEmailAndPasword(String email, String password);
}
