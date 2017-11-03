package com.lahib.db.controllers;

import com.lahib.db.entities.Employee;
import com.lahib.db.services.EmployeeServiceImpl;
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
public class EmployeeController extends BaseController {


    private EmployeeServiceImpl service;

    @Autowired
    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/employees",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<List<Employee>>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/employees/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Employee> get(@PathVariable("id") long id) {
        Employee employee = service.findById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/employees",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        Employee savedEmployee = service.save(employee);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/employees/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee updatedEmployee = service.update(employee);
        if (updatedEmployee == null) {
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/employees/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE
    )
    public ResponseEntity<Employee>  delete(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
