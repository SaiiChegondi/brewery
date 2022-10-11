package com.spring.demo.services.v2;

import java.util.UUID;

import com.spring.demo.model.v2.BeerDtoV2;

public interface BeerServiceV2 {

	Object getBeerById(UUID beerId);

	BeerDtoV2 SaveNewBeer(BeerDtoV2 beerDto);

	void updateBeer(UUID beerId, BeerDtoV2 beerdto);

	void deleteById(UUID beerId);

}
