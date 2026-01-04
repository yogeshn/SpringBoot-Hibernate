package com.example.service;

import java.util.List;

import com.example.model.Product;
import javax.validation.Valid;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getAllProducts();

	List<Product> searchProduct(String productName);

}
