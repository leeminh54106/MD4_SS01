package com.ra.session01.repository;

import com.ra.session01.model.entity.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();
    Product findById(Long id);
    Boolean save(Product product);
    Boolean deleteById(Long id);
}
