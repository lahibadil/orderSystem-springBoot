package com.lahib.db.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Adil on 4/12/2017.
 */

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "jobTitle")
    private String jobTitle;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;

}
