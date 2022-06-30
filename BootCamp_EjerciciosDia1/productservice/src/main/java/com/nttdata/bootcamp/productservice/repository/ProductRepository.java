package com.nttdata.bootcamp.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findProductdById(Long id);
}
