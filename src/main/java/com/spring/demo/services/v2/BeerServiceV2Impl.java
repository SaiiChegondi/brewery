package com.spring.demo.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spring.demo.model.v2.BeerDtoV2;


@Service
public class BeerServiceV2Impl implements BeerServiceV2{

	@Override
	public Object getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeerDtoV2 SaveNewBeer(BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
