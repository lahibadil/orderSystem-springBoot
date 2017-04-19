package com.lahib.db.services;

import com.lahib.db.entities.Employee;
import com.lahib.db.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(long id) {
        return employeeRepository.findOne(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public Employee update(Employee employee) {
        return save(employee);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void delete(long id) {
        employeeRepository.delete(id);
    }
}
