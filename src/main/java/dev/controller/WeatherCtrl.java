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


}
