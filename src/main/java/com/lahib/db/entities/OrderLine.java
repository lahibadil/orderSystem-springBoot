package com.lahib.db.entities;

import com.lahib.db.entities.ids.OrderLineID;
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
@Table(name = "orderLines")
public class OrderLine {

    @EmbeddedId
    private OrderLineID lineID;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @MapsId("order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("product_id")
    private Product product;

    @Column
    private int quantity;
    @Column
    private BigDecimal unitPrice;
    @Column
    private int lineNumber;

}
