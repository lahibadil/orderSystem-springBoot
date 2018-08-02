package com.lahib.db.services;

import com.lahib.db.entities.Supplier;
import com.lahib.db.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
public class SupplierServiceImpl implements SupplierService{
    @Autowired
    private SupplierRepository supplierRepository;

    public Optional<Supplier> findById(long id) {
        return supplierRepository.findById(id);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.saveAndFlush(supplier);
    }

    public Supplier update(Supplier supplier) {
        return save(supplier);
    }

    public void delete(Supplier supplier) {
        supplierRepository.delete(supplier);
    }

    public void delete(long id) {
        supplierRepository.deleteById(id);
    }
}
