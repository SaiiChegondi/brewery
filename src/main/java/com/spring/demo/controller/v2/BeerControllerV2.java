package com.spring.demo.controller.v2;

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
import com.spring.demo.model.v2.BeerDtoV2;
import com.spring.demo.services.BeerService;
import com.spring.demo.services.v2.BeerServiceV2;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

	
	@Autowired
	private BeerServiceV2 beerServiceV2;
	
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId)
	{
		return new ResponseEntity(beerServiceV2.getBeerById(beerId),HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity handlepost(@RequestBody BeerDtoV2 beerDto)
	{
		BeerDtoV2 savedDto=beerServiceV2.SaveNewBeer(beerDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Location", "/api/v1/beer"+savedDto.getId().toString());
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID beerId,@RequestBody BeerDtoV2 beerdto)
	{
		beerServiceV2.updateBeer(beerId,beerdto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);

	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId)
	{
		beerServiceV2.deleteById(beerId);
	}
}

