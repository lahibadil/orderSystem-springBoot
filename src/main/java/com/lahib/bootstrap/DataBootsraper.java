package com.lahib.bootstrap;

import com.lahib.db.aspects.TrackTime;
import com.lahib.db.entities.Customer;
import com.lahib.db.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataBootsraper implements ApplicationListener<ContextRefreshedEvent> {
    private CustomerService customerService;

    @Autowired
    public DataBootsraper(CustomerService customerService) {
        this.customerService = customerService;
    }

    @TrackTime
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        log.info(">>>BootStrapping");
        Customer customer = new Customer();
        customer.getContacts().put("Adil","Manager");
        customer.setCompany("B-AGILE");
        customer.setPhoneMobile("0987654321");

        customerService.save(customer);
        log.info("<<<BootStrapped");
    }
}
