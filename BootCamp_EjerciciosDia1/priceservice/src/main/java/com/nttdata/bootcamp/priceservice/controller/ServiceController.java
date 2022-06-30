package com.nttdata.bootcamp.priceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.priceservice.model.Price;
import com.nttdata.bootcamp.priceservice.service.PriceServiceImpl;

@RestController
public class ServiceController {

	@Autowired
	PriceServiceImpl priceService;
	
	@RequestMapping("/get-price/{idproduct}")
	public ResponseEntity<Price> priceProduct(@PathVariable("idproduct") Long idProduct) {
		
		Price priceObject = priceService.getPrice(idProduct);
		
		
		return ResponseEntity.ok(priceObject);
	}
	
	@GetMapping("/get-all-prices")
	public List<Price> listPriceProduct() {
		
		List<Price> list_price = priceService.getAllPrice();
		
		return list_price;
	}
}
