package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
