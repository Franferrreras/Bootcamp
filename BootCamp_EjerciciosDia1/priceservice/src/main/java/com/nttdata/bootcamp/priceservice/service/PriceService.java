package com.nttdata.bootcamp.priceservice.service;

import com.nttdata.bootcamp.priceservice.model.Price;

public interface PriceService {

	public Price getPrice(Long idProduct);
}
