package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
    
    @PostMapping("/addProduct")
    public void addProduct(@Valid @RequestBody Product product) {
    	
    	productService.saveProduct(product);
    }
    
    @PostMapping("/searchProduct")
    public List<Product> searchProduct(@Valid @RequestBody Product searchedProduct) {
    	
    	List<Product> list = productService.searchProduct(searchedProduct.getProductName());
//    			products.values()
//    		.stream()
//    		.filter(product -> product.getProductName().toLowerCase().startsWith(searchedProduct.getProductName().toLowerCase()))
//    		.collect(Collectors.toList());	
    	
    	return list;
    	
    }
    
    @GetMapping("/allProducts")
    public List<Product> allProducts() {

    	List<Product> allProducts = productService.getAllProducts();
    	
    	return allProducts;
    }

}
