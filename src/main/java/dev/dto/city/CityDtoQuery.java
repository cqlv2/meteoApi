package dev.dto.city;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;

public class CityDtoQuery extends SuperDto {

	private String cityName;
	private String InseeCode;
	private Long population;
	private String state;
	private String department;
	private List<Long> weathersId = new ArrayList<>();
	private List<Long> polluantsId = new ArrayList<>();

	// getter setter
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getInseeCode() {
		return InseeCode;
	}

	public void setInseeCode(String inseeCode) {
		InseeCode = inseeCode;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Long> getWeathersId() {
		return weathersId;
	}

	public void setWeathersId(List<Long> weathersId) {
		this.weathersId = weathersId;
	}

	public List<Long> getPolluantsId() {
		return polluantsId;
	}

	public void setPolluantsId(List<Long> polluantsId) {
		this.polluantsId = polluantsId;
	}

}
