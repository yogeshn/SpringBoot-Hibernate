package com.example.dao;

import java.util.List;

import com.example.model.Product;

public interface ProductDAO {
	public void saveProduct(Product product);

	public List<Product> getAllProducts();

	public List<Product> searchProductIgnoreCase(String name);
}
