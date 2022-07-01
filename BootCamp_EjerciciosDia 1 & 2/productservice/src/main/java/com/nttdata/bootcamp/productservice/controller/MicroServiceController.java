package com.nttdata.bootcamp.productservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.productservice.model.Product;
import com.nttdata.bootcamp.productservice.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class MicroServiceController {

	@Autowired
	private ProductServiceImpl productService;
	
//	@GetMapping()
//	public ArrayList<OrderDetail> api() {
//		ArrayList<OrderDetail> list = orderService.getAllOrderDetails();
//		return orderService.getAllOrderDetails();
//	}
	
//	@RequestMapping("/")
//	public String home() {
//		
//		return "Hellow world";
//	}
	
//	public static void main(String[] args) {
//		
//		new SpringApplicationBuilder(MicroServiceController.class).run(args);
//	}
	
	@GetMapping
	public ResponseEntity<List<Product>> listProduct() {
		
		List<Product> list_product = productService.getAllProducts();
		if (list_product.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list_product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		
		Product product = productService.getProductById(id);
		
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		
		Product productDB = productService.saveProduct(product);
		return ResponseEntity.ok(productDB);
	}
}
