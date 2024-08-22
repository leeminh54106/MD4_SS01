package com.ra.session01.service;

import com.ra.session01.model.entity.Product;
import com.ra.session01.repository.IProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Boolean save(Product product) {
        if (product.getId() == null) {
            product.setSku(UUID.randomUUID().toString());
        }
       return productRepo.save(product);
    }

    @Override
    public Boolean deleteById(Long id) {
        return productRepo.deleteById(id);
    }
}
