package com.example.reto5ciclo4.repositorio;

import java.util.List;
import java.util.Optional;

import com.example.reto5ciclo4.interfaces.InterfaceUser;
import com.example.reto5ciclo4.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author PSG94
 * Reto 5 Ciclo4
 */

@Repository
public class UserRepository {
    @Autowired
    private InterfaceUser userCrudRepository;

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public List<User> listAll() {
        return userCrudRepository.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }

    public User update(User user) {
        return userCrudRepository.save(user);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }

}

