package com.lahib.db.controllers;

import com.lahib.db.entities.Order;
import com.lahib.db.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@RestController
@RequestMapping("/api/")
public class OrderController extends BaseController {

    @Autowired
    private OrderServiceImpl service;

    @RequestMapping(
            value = "/orders",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<List<Order>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/orders/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Order> get(@PathVariable("id") long id) {
        Order order = service.findById(id);
        if (order == null) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/orders",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Order savedOrder = service.save(order);
        if (order == null) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/orders/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Order> update(@RequestBody Order order) {
        Order updatedOrder = service.update(order);
        if (updatedOrder == null) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/orders/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Order>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
