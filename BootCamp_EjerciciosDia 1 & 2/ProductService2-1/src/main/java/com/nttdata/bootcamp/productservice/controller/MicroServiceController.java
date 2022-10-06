package com.nttdata.bootcamp.productservice.controller;

import java.util.Enumeration;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.productservice.dto.ProductDTO;
import com.nttdata.bootcamp.productservice.service.ProductManagementServiceI;


@RestController
@RequestMapping("/product")
public class MicroServiceController {

	@Autowired
	ProductManagementServiceI productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> MethodGet(@PathVariable("id") Long id) {
		
		ProductDTO product = productService.ProductGet(id);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<ProductDTO> MethodPost(@PathVariable("id") Long id) {
		
		ProductDTO product = productService.ProductPost(id);
		return ResponseEntity.ok(product);
		
	}
}
