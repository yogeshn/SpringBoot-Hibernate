package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getAllProducts();

	List<Product> searchProduct(String productName);

}