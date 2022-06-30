package com.nttdata.bootcamp.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.productservice.model.Product;
import com.nttdata.bootcamp.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findProductdById(id);
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		Product productDB = productRepo.save(product);
		
		return productDB;
	}

}
