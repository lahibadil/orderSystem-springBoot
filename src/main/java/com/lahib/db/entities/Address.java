package com.lahib.db.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Embeddable
public class Address {

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;


}
