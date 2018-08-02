package com.lahib.db.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipper_id")
    private long id;

    @Column(name = "companyName")
    private String company;

    @ElementCollection
    @CollectionTable(name = "shipper_contacts", joinColumns = @JoinColumn(name = "shipper_id"))
    @MapKeyColumn(name = "contactJobTitle")
    @Column(name = "contactName")
    private Map<String, String> contacts;

}
