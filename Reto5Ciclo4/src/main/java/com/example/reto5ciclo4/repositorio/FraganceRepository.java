package com.example.reto5ciclo4.repositorio;

import java.util.List;
import java.util.Optional;

import com.example.reto5ciclo4.interfaces.InterfaceFragance;
import com.example.reto5ciclo4.modelo.Fragance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author PSG94
 * Reto 5 Ciclo4
 */

@Repository
public class FraganceRepository {
    @Autowired
    private InterfaceFragance fraganceCrudRepository;

    public List<Fragance> getAll() {
        return fraganceCrudRepository.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceCrudRepository.findById(reference);
    }
    public Fragance create(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }

    public void update(Fragance fragance) {
        fraganceCrudRepository.save(fragance);
    }

    public void delete(Fragance fragance) {
        fraganceCrudRepository.delete(fragance);
    }

    public List<Fragance> gadgetsByPrice(double precio) {
        return fraganceCrudRepository.findByPriceLessThanEqual(precio);
    }

    public List<Fragance> findByDescriptionLike(String description) {
        return fraganceCrudRepository.findByDescriptionLike(description);
    }

}
