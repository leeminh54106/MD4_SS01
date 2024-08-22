package com.ra.session01.repository;

import com.ra.session01.model.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class ProductRepoImpl implements IProductRepo {
    @PersistenceContext
    public EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Boolean save(Product product) {

        if(product.getId() == null) {
            entityManager.persist(product);
        }else{
            entityManager.merge(product);
        }
        return true;
    }

    @Override
    public Boolean deleteById(Long id) {
        entityManager.remove(findById(id));
        return true;
    }
}
