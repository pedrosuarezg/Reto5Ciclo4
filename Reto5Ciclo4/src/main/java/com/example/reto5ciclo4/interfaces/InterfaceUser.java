package com.example.reto5ciclo4.interfaces;

import com.example.reto5ciclo4.modelo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InterfaceUser extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email,String password);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
