package com.example.reto5ciclo4;

import com.example.reto5ciclo4.interfaces.InterfaceFragance;
import com.example.reto5ciclo4.interfaces.InterfaceOrder;
import com.example.reto5ciclo4.interfaces.InterfaceUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto5Ciclo4Application implements CommandLineRunner {

    @Autowired
    private InterfaceUser interfaceUser;

    @Autowired
    private InterfaceFragance interfaceFragance;

    @Autowired
    private InterfaceOrder interfaceOrder;

    public static void main(String[] args) {
        SpringApplication.run(Reto5Ciclo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        interfaceUser.deleteAll();
        interfaceFragance.deleteAll();
        interfaceOrder.deleteAll();

    }

}
