package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.Product;

public interface ProductDAO extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> searchProductIgnoreCase(@Param("name") String name);
}
