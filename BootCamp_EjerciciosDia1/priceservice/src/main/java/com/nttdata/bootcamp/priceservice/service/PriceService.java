package com.nttdata.bootcamp.priceservice.service;

import java.util.List;

import com.nttdata.bootcamp.priceservice.model.Price;

public interface PriceService {

	public Price getPrice(Long idProduct);
	public List<Price> getAllPrice();
}
