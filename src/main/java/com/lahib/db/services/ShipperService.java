package com.lahib.db.services;

import com.lahib.db.entities.Shipper;
import com.lahib.db.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
@Configurable
public class ShipperService {
    @Autowired
    private ShipperRepository shipperRepository;

    public Shipper findById(long id) {
        return shipperRepository.findOne(id);
    }

    public List<Shipper> findAll() {
        return shipperRepository.findAll();
    }

    public Shipper save(Shipper shipper) {
        return shipperRepository.saveAndFlush(shipper);
    }

    public Shipper update(Shipper shipper) {
        return save(shipper);
    }

    public void delete(Shipper shipper) {
        shipperRepository.delete(shipper);
    }

    public void delete(long id) {
        shipperRepository.delete(id);
    }
}
