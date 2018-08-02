package com.lahib.db.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "productCode")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "suggestedUnitPrice")
    private BigDecimal suggestedUnitPrice;

    @Column(name = "buyUnitPrice")
    private BigDecimal buyUnitPrice;

    @Column(name = "unitsInStock")
    private int unitsInStock;

    @Column(name = "unitsOnOrder")
    private int unitsOnOrder;

    @Column(name = "reorderLevel")
    private int reorderLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_suppliers", joinColumns = @JoinColumn(name = "product_id")
            , inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> suppliers;
}
