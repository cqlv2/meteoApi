package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.dto.city.CityDtoQuery;
import dev.entity.City;
import dev.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityCtrl extends SuperController<City, CityService> {

	// methode a ajouter au super controlleur mais pour le moment probleme
	// d'integration de dto !

	/**
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody CityDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody CityDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	// methode specific
	/**
	 * manually updates the database. administrator required
	 */
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/updatebdd")
	public void updatebdd() {
		try {
			service.updateCityFromApi();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	

}
