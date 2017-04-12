package com.lahib.db.entities.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Adil on 4/12/2017.
 */
@Embeddable
public class InvoiceLineID implements Serializable {
    private long invoice_id;
    private long product_id;

    public long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }
}
