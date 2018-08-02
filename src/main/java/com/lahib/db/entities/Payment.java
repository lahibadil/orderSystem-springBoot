package com.lahib.db.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "order_id")
    private Order order;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date payementDate;
    private BigDecimal amount;
    private String checkNumber;


}
