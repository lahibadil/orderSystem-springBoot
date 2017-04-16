package com.lahib.db.controllers;

import com.lahib.db.entities.Customer;
import com.lahib.db.services.CustomerService;
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
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService service;

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<List<Customer>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> get(@PathVariable("id") long id) {
        Customer customer = service.findById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/customers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer savedCustomer = service.save(customer);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        Customer updatedCustomer = service.update(customer);
        if (updatedCustomer == null) {
            return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Customer>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
