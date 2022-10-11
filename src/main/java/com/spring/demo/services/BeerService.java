package com.spring.demo.services;

import java.util.UUID;

import com.spring.demo.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto SaveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerdto);

	void deleteById(UUID beerId);

}
