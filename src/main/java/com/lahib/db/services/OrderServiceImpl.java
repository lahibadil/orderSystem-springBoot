package com.lahib.db.services;

import com.lahib.db.entities.Order;
import com.lahib.db.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    public Order update(Order order) {
        return save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}
