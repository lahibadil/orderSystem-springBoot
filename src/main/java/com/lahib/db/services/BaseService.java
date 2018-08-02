package com.lahib.db.services;

import java.util.List;
import java.util.Optional;

/**
 * Created by Adil on 4/19/2017.
 */
public interface BaseService<T> {
    Optional<T> findById(long id);

    List<T> findAll();

    T save(T entity);

    void delete(T entity);

    void delete(long id);
}
