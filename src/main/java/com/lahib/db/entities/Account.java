package com.lahib.db.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Adil on 4/19/2017.
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean enabled = true;

    @NotNull
    private boolean credentialsexpired = false;

    @NotNull
    private boolean expired = false;

    @NotNull
    private boolean locked = false;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "AccountRole",
            joinColumns = @JoinColumn(
                    name = "accountId",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "roleId",
                    referencedColumnName = "id"))
    private Set<Role> roles;

}
