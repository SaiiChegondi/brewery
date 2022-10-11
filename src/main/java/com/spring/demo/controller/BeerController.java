package com.spring.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.BeerDto;
import com.spring.demo.services.BeerService;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	
	@Autowired
	private BeerService beerService;
	
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId)
	{
		return new ResponseEntity<>(beerService.getBeerById(beerId),HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity handlepost(@RequestBody BeerDto beerDto)
	{
		BeerDto savedDto=beerService.SaveNewBeer(beerDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Location", "/api/v1/beer"+savedDto.getId().toString());
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID beerId,@RequestBody BeerDto beerdto)
	{
		beerService.updateBeer(beerId,beerdto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);

	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId)
	{
		beerService.deleteById(beerId);
	}
}


















