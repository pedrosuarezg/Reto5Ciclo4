package com.example.reto5ciclo4.interfaces;

import com.example.reto5ciclo4.modelo.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InterfaceFragance extends MongoRepository<Fragance, String> {
    public List<Fragance> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Fragance> findByDescriptionLike(String description);
}

