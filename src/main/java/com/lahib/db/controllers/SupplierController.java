package com.lahib.db.controllers;

import com.lahib.db.entities.Supplier;
import com.lahib.db.services.SupplierServiceImpl;
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
public class SupplierController extends BaseController {

    @Autowired
    private SupplierServiceImpl service;

    @RequestMapping(
            value = "/suppliers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Supplier>> getAll() {
        return new ResponseEntity<List<Supplier>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/suppliers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Supplier> get(@PathVariable("id") long id) {
        Supplier supplier = service.findById(id);
        if (supplier == null) {
            return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/suppliers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier) {
        Supplier savedSupplier = service.save(supplier);
        if (supplier == null) {
            return new ResponseEntity<Supplier>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Supplier>(savedSupplier, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/suppliers/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Supplier> update(@RequestBody Supplier supplier) {
        Supplier updatedSupplier = service.update(supplier);
        if (updatedSupplier == null) {
            return new ResponseEntity<Supplier>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Supplier>(updatedSupplier, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/suppliers/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Supplier>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Supplier>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
