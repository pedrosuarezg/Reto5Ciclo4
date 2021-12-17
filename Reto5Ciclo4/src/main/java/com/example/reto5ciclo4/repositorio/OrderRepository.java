package com.example.reto5ciclo4.repositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.example.reto5ciclo4.interfaces.InterfaceOrder;
import com.example.reto5ciclo4.modelo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author PSG94
 * Reto 5 Ciclo4
 */

@Repository
public class OrderRepository {
    @Autowired
    private InterfaceOrder orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    public Optional<Order> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }

    public List<Order> ordersSalesManByID(Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    public List<Order> ordersSalesManByState(String state, Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }
}
