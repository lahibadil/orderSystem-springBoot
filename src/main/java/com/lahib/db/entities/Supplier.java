package com.lahib.db.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long id;

    @Column(name = "compnayName")
    private String company;

    @Column(name = "contactName")
    private String contact;

    @Column(name = "contactJobTitle")
    private String contactjobTitle;

    @Column(name = "phoneOffice", unique = true, length = 10)
    private String phoneOffice;

    @Column(name = "phoneMobile", unique = true, length = 10)
    private String phoneMobile;

    @Column(name = "fax", length = 10)
    private String fax;

    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "suppliers")
    private List<Product> products;

}
