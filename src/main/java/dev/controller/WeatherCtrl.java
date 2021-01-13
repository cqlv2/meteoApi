package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import dev.dto.weather.WeatherDtoQuery;
import dev.dto.weather.WeatherDtoResponse;
import dev.entity.Weather;
import dev.service.WeatherService;

@RestController
@RequestMapping("/api/admin/weather")
public class WeatherCtrl extends SuperController<Weather, WeatherService, WeatherDtoQuery, WeatherDtoResponse>{
	
	/**
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody WeatherDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody WeatherDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

}
