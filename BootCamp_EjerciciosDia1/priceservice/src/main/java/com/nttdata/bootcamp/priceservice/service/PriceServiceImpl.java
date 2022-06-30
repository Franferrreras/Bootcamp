package com.nttdata.bootcamp.priceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nttdata.bootcamp.priceservice.model.Price;
import com.nttdata.bootcamp.priceservice.model.Product;
import com.nttdata.bootcamp.priceservice.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	PriceRepository priceRepo;
	
	@Override
	public Price getPrice(Long idProduct) {

		Product product = restTemplate.getForObject("http://localhost:8080/product/"+idProduct, Product.class);
		
		Price priceObj = new Price();
		priceObj.setCode_product(String.valueOf(idProduct));
		priceObj.setDescription(product.getDescription());
		priceObj.setPrice(product.getPrice());
		
		priceRepo.save(priceObj);
		return priceObj;
	}

}
