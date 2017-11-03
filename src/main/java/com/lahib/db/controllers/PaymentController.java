package com.lahib.db.controllers;

import com.lahib.db.entities.Payment;
import com.lahib.db.services.PaymentServiceImpl;
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
public class PaymentController extends BaseController {


    private PaymentServiceImpl service;

    @Autowired
    public PaymentController(PaymentServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/payments",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Payment>> getAll() {
        return new ResponseEntity<List<Payment>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payments/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Payment> get(@PathVariable("id") long id) {
        Payment payment = service.findById(id);
        if (payment == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Payment>(payment, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/payments",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        Payment savedPayment = service.save(payment);
        if (payment == null) {
            return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Payment>(savedPayment, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/payments/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        Payment updatedPayment = service.update(payment);
        if (updatedPayment == null) {
            return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Payment>(updatedPayment, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/payments/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Payment>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
