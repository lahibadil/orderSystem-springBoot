package com.lahib.db.services;

import com.lahib.db.entities.Customer;
import com.lahib.db.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(long id) {
        return customerRepository.findOne(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public void delete(long id) {
        customerRepository.delete(id);
    }
}
