package com.lahib.db.controllers;

import com.lahib.db.entities.Product;
import com.lahib.db.services.ProductServiceImpl;
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
public class ProductController extends BaseController {

    @Autowired
    private ProductServiceImpl service;

    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> get(@PathVariable("id") long id) {
        Product product = service.findById(id);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product savedProduct = service.save(product);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Product updatedProduct = service.update(product);
        if (updatedProduct == null) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Product>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
