package com.lahib.db.entities;

import com.lahib.db.entities.enums.InvoiceStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "invoiceDate")
    private Date invoiceDate;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceLine> invoiceLines;

}
