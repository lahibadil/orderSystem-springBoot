package com.lahib.db.services;

import com.lahib.db.entities.Invoice;
import com.lahib.db.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice findById(long id) {
        return invoiceRepository.findOne(id);
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.saveAndFlush(invoice);
    }

    public Invoice update(Invoice invoice) {
        return save(invoice);
    }

    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    public void delete(long id) {
        invoiceRepository.delete(id);
    }
}
