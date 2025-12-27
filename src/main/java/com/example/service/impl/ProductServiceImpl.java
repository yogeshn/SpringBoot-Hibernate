package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public List<Product> searchProduct(String productName) {
		return productDAO.searchProductIgnoreCase(productName);
	}
}
