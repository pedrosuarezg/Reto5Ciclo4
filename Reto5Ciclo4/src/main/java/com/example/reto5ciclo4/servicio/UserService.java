package com.example.reto5ciclo4.servicio;

import java.util.List;
import java.util.Optional;


import com.example.reto5ciclo4.modelo.User;
import com.example.reto5ciclo4.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author PSG94
 * Reto 5 Ciclo4
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;

    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }

    public List<User> listAll() {
        return repositorio.listAll();
    }

    public boolean emailExists(String email) {
        return repositorio.emailExists(email);
    }

    public User autenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public User create(User user) {

        Optional<User> userIdMaximo;

        if (user.getId() == null) {

            userIdMaximo = repositorio.lastUserId();

            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }

        Optional<User> e = repositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return repositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                repositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Optional<User> usuario = getUser(userId);

        if (usuario.isEmpty()){
            return false;
        }else{
            repositorio.delete(usuario.get());
            return true;
        }
        /*
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;

        */
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return repositorio.birthtDayList(monthBirthtDay);
    }
}
