package com.lahib.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Adil on 4/19/2017.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Entity
public class Role {

    @Id
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String label;
}