package com.nttdata.bootcamp.priceservice.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.nttdata.bootcamp.priceservice.model.Price;
import com.nttdata.bootcamp.priceservice.model.Product;
import com.nttdata.bootcamp.priceservice.repository.PriceRepository;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.ForIndex;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	PriceRepository priceRepo;

	@Override
	public Price getPrice(Long idProduct) {

		Product product = restTemplate.getForObject("http://localhost:8080/product/" + idProduct, Product.class);

		Price priceObj = new Price();
		priceObj.setCodeProduct(String.valueOf(idProduct));
		priceObj.setDescription(product.getDescription());
		priceObj.setPrice(product.getPrice());

		if (priceRepo.save(priceObj) != null) {
			return priceObj;
		}

		return null;
	}

	@Override
	public List<Price> getAllPrice() {
		Gson gson = new Gson();

		String list_productJson = restTemplate.getForObject("http://localhost:8080/product", String.class);

		Type type = new TypeToken<List<Product>>() {
		}.getType();

		List<Product> list_product = gson.fromJson(list_productJson, type);

		List<Price> list_price = new ArrayList();

		System.out.println(list_product);

		for (Product p : list_product) {

			Price priceObj = new Price();
			priceObj.setPrice(p.getPrice());
			priceObj.setDescription(p.getDescription());
			priceObj.setCodeProduct(String.valueOf(p.getId()));

			priceRepo.save(priceObj);

			list_price.add(priceObj);
		}

		return list_price;
	}

}
