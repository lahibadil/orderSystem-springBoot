package com.lahib.db.entities.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Adil on 4/12/2017.
 */
@Embeddable
public class OrderLineID implements Serializable {

    private long order_id;
    private long product_id;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }
}
