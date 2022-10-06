package com.nttdata.bootcamp.productservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.nttdata.bootcamp.productservice.dto.ProductDTO;

@RequestScope
@Service
public class ProductManagementServiceImpl implements ProductManagementServiceI {

	@Value("${server.port}")
	private String port;

	@Override
	public ProductDTO ProductGet(Long id) {
		// TODO Auto-generated method stub
		ProductDTO product = new ProductDTO();
		product.setId(id);
		product.setChannel("GET");
		product.setServerPort(port);
		
		return product;
	}

	@Override
	public ProductDTO ProductPost(Long id) {
		// TODO Auto-generated method stub
		ProductDTO product = new ProductDTO();
		product.setId(id);
		product.setChannel("POST");
		product.setServerPort(port);
		
		return product;
	}

}
