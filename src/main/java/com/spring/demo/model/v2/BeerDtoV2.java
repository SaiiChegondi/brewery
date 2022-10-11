package com.spring.demo.model.v2;

import java.util.UUID;

import com.spring.demo.model.BeerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {
	private UUID id;
	private String beerName;
	private BeerDtoStyle beerStyle;
	private Long udc;
	

}
