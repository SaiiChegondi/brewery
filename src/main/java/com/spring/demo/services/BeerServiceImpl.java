package com.spring.demo.services;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.demo.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService{

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}
	
	@Override
	public BeerDto SaveNewBeer(BeerDto beerDto)
	{
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}
	
	@Override
	public 	void updateBeer(UUID beerId, BeerDto beerdto)
	{
	}

	@Override
	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
