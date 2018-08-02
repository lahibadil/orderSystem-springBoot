package com.lahib.db.services;

import com.lahib.db.entities.OrderLine;
import com.lahib.db.repositories.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;

    public Optional<OrderLine> findById(long id) {
        return orderLineRepository.findById(id);
    }

    public List<OrderLine> findAll() {
        return orderLineRepository.findAll();
    }

    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.saveAndFlush(orderLine);
    }

    public OrderLine update(OrderLine orderLine) {
        return save(orderLine);
    }

    public void delete(OrderLine orderLine) {
        orderLineRepository.delete(orderLine);
    }

    public void delete(long id) {
        orderLineRepository.deleteById(id);
    }
}
