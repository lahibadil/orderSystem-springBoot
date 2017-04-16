package com.lahib.db.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shpper_id")
    private long id;

    @Column(name = "companyName")
    private String company;

    @ElementCollection
    @CollectionTable(name = "shiper_contact", joinColumns = @JoinColumn(name = "shiper_id"))
    @MapKeyColumn(name = "contactJobTitle")
    @Column(name = "contactName")
    private Map<String, String> contacts;

}