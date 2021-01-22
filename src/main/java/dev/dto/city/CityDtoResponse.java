package dev.dto.city;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.polluant.PolluantDtoResponse;
import dev.dto.weather.WeatherDtoResponse;
import dev.entity.City;
import dev.entity.Polluant;
import dev.entity.Weather;
import dev.utils.transformer.PolluantTransformer;
import dev.utils.transformer.WeatherTransformer;

public class CityDtoResponse extends SuperDto {

	private String cityName;
	private String inseeCode;

	private Long population;
	private String state;
	private String department;
	private List<WeatherDtoResponse> weathers = new ArrayList<>();
	private List<PolluantDtoResponse> polluants = new ArrayList<>();
	private Double longitude;
	private Double latitude;

	// constructeur
	public CityDtoResponse(City entity) {
		this.id=entity.getId();
		this.dateAdd=entity.getDateAdd();
		this.cityName = entity.getCityName();
		this.inseeCode = entity.getInseeCode();
		this.population = entity.getPopulation();
		this.state = entity.getState();
		this.department = entity.getDepartment();
		this.longitude = entity.getLongitude();
		this.latitude = entity.getLatitude();
		
		
		for (Weather weather : entity.getWeathers()) {
			this.weathers.add(WeatherTransformer.entityToDtoResponse(weather));
		}
		for (Polluant polluant : entity.getPolluants()) {
			this.polluants.add(PolluantTransformer.entityToDtoResponse(polluant));
		}
	}

	// getteurSetteur
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getInseeCode() {
		return inseeCode;
	}

	public void setInseeCode(String inseeCode) {
		this.inseeCode = inseeCode;
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

	public List<WeatherDtoResponse> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<WeatherDtoResponse> weathers) {
		this.weathers = weathers;
	}

	public List<PolluantDtoResponse> getPolluants() {
		return polluants;
	}

	public void setPolluants(List<PolluantDtoResponse> polluants) {
		this.polluants = polluants;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	

}
