package com.nttdata.bootcamp.productservice.service;

import org.springframework.beans.factory.annotation.Value;

import com.nttdata.bootcamp.productservice.dto.ProductDTO;

public interface ProductManagementServiceI {

	public ProductDTO ProductGet(Long id);

	public ProductDTO ProductPost(Long id);
}
