package com.lahib.db.controllers;

import com.lahib.db.entities.Invoice;
import com.lahib.db.services.InvoiceServiceImpl;
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
public class InvoiceController extends BaseController {

    @Autowired
    private InvoiceServiceImpl service;

    @RequestMapping(
            value = "/invoices",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Invoice>> getAll() {
        return new ResponseEntity<List<Invoice>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/invoices/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Invoice> get(@PathVariable("id") long id) {
        Invoice invoice = service.findById(id);
        if (invoice == null) {
            return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/invoices",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Invoice> save(@RequestBody Invoice invoice) {
        Invoice savedInvoice = service.save(invoice);
        if (invoice == null) {
            return new ResponseEntity<Invoice>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Invoice>(savedInvoice, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/invoices/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice) {
        Invoice updatedInvoice = service.update(invoice);
        if (updatedInvoice == null) {
            return new ResponseEntity<Invoice>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Invoice>(updatedInvoice, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/invoices/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Invoice>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Invoice>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Invoice>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
