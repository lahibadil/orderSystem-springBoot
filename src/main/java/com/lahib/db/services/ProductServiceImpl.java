package com.lahib.db.services;

import com.lahib.db.entities.Product;
import com.lahib.db.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 4/12/2017.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public Product update(Product product) {
        return save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }
}
