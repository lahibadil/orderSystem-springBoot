package com.lahib.db.controllers;

import com.lahib.db.entities.Shipper;
import com.lahib.db.services.ShipperServiceImpl;
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
public class ShipperController extends BaseController {


    private ShipperServiceImpl service;

    @Autowired
    public ShipperController(ShipperServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/shippers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Shipper>> getAll() throws Exception {
       // return new ResponseEntity<List<Shipper>>(service.findAll(), HttpStatus.OK);
        throw new Exception("An Error has occured");
    }

    @RequestMapping(
            value = "/shippers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Shipper> get(@PathVariable("id") long id) {
        Shipper shipper = service.findById(id);
        if (shipper == null) {
            return new ResponseEntity<Shipper>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Shipper>(shipper, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/shippers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Shipper> save(@RequestBody Shipper shipper) {
        Shipper savedShipper = service.save(shipper);
        if (shipper == null) {
            return new ResponseEntity<Shipper>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Shipper>(savedShipper, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/shippers/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Shipper> update(@RequestBody Shipper shipper) {
        Shipper updatedShipper = service.update(shipper);
        if (updatedShipper == null) {
            return new ResponseEntity<Shipper>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Shipper>(updatedShipper, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/shippers/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Shipper>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Shipper>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Shipper>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
