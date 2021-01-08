package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long>{

}
