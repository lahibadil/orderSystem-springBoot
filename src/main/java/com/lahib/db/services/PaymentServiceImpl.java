package com.lahib.db.services;

import com.lahib.db.entities.Payment;
import com.lahib.db.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Optional<Payment> findById(long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment save(Payment payment) {
        return paymentRepository.saveAndFlush(payment);
    }

    public Payment update(Payment payment) {
        return save(payment);
    }

    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    public void delete(long id) {
        paymentRepository.deleteById(id);
    }

}
