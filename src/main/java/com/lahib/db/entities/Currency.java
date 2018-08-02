package com.lahib.db.entities;

import com.lahib.db.entities.ids.CurrencyId;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "currency")
@IdClass(CurrencyId.class)
public class Currency {

    @Id
    private String name;
    @Id
    private String countryName;

    private String symbol;
}
