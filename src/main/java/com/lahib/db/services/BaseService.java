package com.lahib.db.services;

import java.util.List;

/**
 * Created by Adil on 4/19/2017.
 */
public interface BaseService<T> {
    T findById(long id);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void delete(long id);
}
