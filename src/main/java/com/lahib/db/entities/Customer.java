package com.lahib.db.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    private String company;

    @ElementCollection
    @CollectionTable(name = "costumer_contacts", joinColumns = @JoinColumn(name = "customer_id"))
    @MapKeyColumn(name = "contactJobTitle")
    @Column(name = "contactName")
    private Map<String, String> contacts;

    @Column(name = "phoneOffice", length = 10)
    private String phoneOffice;

    @Column(name = "phoneMobile", length = 10)
    private String phoneMobile;

    @Column(name = "fax", length = 10)
    private String fax;

    @Embedded
    private Address address;


    public Customer(){
        contacts = new HashMap<>();
    }
}
