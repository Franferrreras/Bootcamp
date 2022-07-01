package com.nttdata.bootcamp.priceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.priceservice.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}
