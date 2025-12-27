package com.example.dao;

import java.util.List;

import com.example.model.Product;

public interface ProductDAO {
	void saveProduct(Product product);

	List<Product> getAllProducts();

	List<Product> searchProductIgnoreCase(String name);
}
