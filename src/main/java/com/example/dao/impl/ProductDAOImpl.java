package com.example.dao.impl;


import com.example.dao.ProductDAO;
import com.example.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akila on 12/4/16.
 */
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return entityManager.createQuery("from Product").getResultList();
    }

    @Override
    public List<Product> searchProductIgnoreCase(String name) {
        if(name != null) {
            return entityManager.createQuery("from Product where lower(productName) like :pName")
                    .setParameter("pName", name.toLowerCase() + "%")
                    .getResultList();
        } else {
            return new ArrayList<>();
        }
    }
}
