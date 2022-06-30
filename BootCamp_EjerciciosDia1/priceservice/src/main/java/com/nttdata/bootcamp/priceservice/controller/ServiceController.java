package com.nttdata.bootcamp.priceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.priceservice.model.Price;
import com.nttdata.bootcamp.priceservice.service.PriceServiceImpl;

@RestController
@RequestMapping("/get-price")
public class ServiceController {

	@Autowired
	PriceServiceImpl productService;
	
	@GetMapping("/{idproduct}")
	public ResponseEntity<Price> priceProduct(@PathVariable("idproduct") Long idProduct) {
		
		Price priceObject = productService.getPrice(idProduct);
		
		
		return ResponseEntity.ok(priceObject);
	}
}
