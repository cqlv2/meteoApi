package dev.service;

import org.springframework.stereotype.Service;

import dev.dto.weather.WeatherDtoQuery;
import dev.dto.weather.WeatherDtoResponse;
import dev.entity.Weather;
import dev.repository.WeatherRepository;

@Service
public class WeatherService extends SuperService<Weather, WeatherRepository, WeatherDtoResponse, WeatherDtoQuery>{

}
