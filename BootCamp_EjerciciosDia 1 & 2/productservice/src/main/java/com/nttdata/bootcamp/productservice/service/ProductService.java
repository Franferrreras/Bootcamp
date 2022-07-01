package com.nttdata.bootcamp.productservice.service;

import java.util.List;

import com.nttdata.bootcamp.productservice.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	public Product getProductById(Long id);
	public Product saveProduct(Product product);
}
