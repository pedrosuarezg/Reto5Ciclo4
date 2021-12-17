package com.example.reto5ciclo4.controlador;

import java.util.List;
import java.util.Optional;

import com.example.reto5ciclo4.modelo.Fragance;
import com.example.reto5ciclo4.servicio.FraganceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author PSG94
 * Reto 5 Ciclo4
 */

@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceController {
    @Autowired
    private FraganceService fraganceService;

    @GetMapping("/all")
    public List<Fragance> getAll() {
        return fraganceService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Fragance> getFragance(@PathVariable("reference") String reference) {
        return fraganceService.getFragance(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance create(@RequestBody Fragance fragance) {
        return fraganceService.create(fragance);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance) {
        return fraganceService.update(fragance);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return fraganceService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Fragance> gadgetsByPrice(@PathVariable("price") double precio) {
        return fraganceService.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Fragance> findByDescriptionLike(@PathVariable("description") String description) {
        return fraganceService.findByDescriptionLike(description);
    }

}
