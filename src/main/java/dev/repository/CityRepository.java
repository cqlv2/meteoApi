package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

	@Query("select DISTINCT(c.state) from City c")
	String[] getState();

	@Query("select DISTINCT(c.department) from City c")
	String[] getDepartment();
	
}
