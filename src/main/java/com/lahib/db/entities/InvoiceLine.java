package com.lahib.db.entities;

import com.lahib.db.entities.ids.InvoiceLineID;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Adil on 4/12/2017.
 */

@Data
@Accessors(chain = true)
@Entity
@Table(name = "invoiceLines")
public class InvoiceLine {
    @EmbeddedId
    private InvoiceLineID invoiceLineID;

    @ManyToOne
    @MapsId("invoice_id")
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "unitPrice")
    private BigDecimal unitPrice;
    @Column(name = "unitsShipped")
    private int unitsShipped;
    @Column(name = "lineNumber")
    private int lineNumber;
}
