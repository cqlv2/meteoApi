package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.dto.city.CityDtoQuery;
import dev.dto.city.CityDtoResponse;
import dev.entity.City;
import dev.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityCtrl extends SuperController<City, CityService, CityDtoQuery, CityDtoResponse> {

	// methode a ajouter au super controlleur mais pour le moment probleme
	// d'integration de dto !

	/**
	 * method override to prohibit use
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody CityDtoQuery dtoQuery) {
		return ResponseEntity.badRequest().body("prohibited");
	}

	/**
	 * method override to prohibit use
	 */
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody CityDtoQuery dtoQuery) {
		return ResponseEntity.badRequest().body("prohibited");
	}
	//override methodes
	@Override
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
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
