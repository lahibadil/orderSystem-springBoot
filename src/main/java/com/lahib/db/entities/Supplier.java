package com.lahib.db.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long id;

    @Column(name = "companyName")
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
