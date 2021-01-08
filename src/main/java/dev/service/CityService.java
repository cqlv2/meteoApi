package dev.service;

import org.springframework.stereotype.Service;

import dev.dto.city.CityDtoQuery;
import dev.dto.city.CityDtoResponse;
import dev.entity.City;
import dev.repository.CityRepository;

@Service
public class CityService extends SuperService<City, CityRepository, CityDtoResponse, CityDtoQuery>{

}
