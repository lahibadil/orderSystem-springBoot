package com.lahib.db.entities;

import com.lahib.db.entities.enums.OrderStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderDate")
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requiredDtae")
    private Date requiredDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus")
    private OrderStatus orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shipDate")
    private Date shipedDate;

    @Column(name = "shipToName")
    private String shipToName;

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "line1", column = @Column(name = "shipToLine1")),
                    @AttributeOverride(name = "line2", column = @Column(name = "shipToLine2")),
                    @AttributeOverride(name = "city", column = @Column(name = "shipToCity")),
                    @AttributeOverride(name = "zip", column = @Column(name = "shipToZip")),
                    @AttributeOverride(name = "country", column = @Column(name = "shipToCountry")),
            }
    )
    private Address shipToAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderLine> orderLines;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Payment payment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<Invoice> invoices;


    public Order(){
        invoices = new ArrayList<Invoice>();
        orderLines = new ArrayList<OrderLine>();
    }

}
