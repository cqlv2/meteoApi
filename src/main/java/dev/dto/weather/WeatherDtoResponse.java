package dev.dto.weather;

import dev.dto.SuperDto;
import dev.entity.Weather;


public class WeatherDtoResponse extends SuperDto{
	
	private Double temp;
	private Double tempMax;
	private Double tempMin;
	private Integer windDirection;
	private Double windSpeed;
	private Double humidity;
	private Double pressure;
	//TODO 
	//private Meteo prevision;
	
	public WeatherDtoResponse(Weather entity) {
		this.id = entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.temp = entity.getTemp();
		this.tempMax = entity.getTempMax();
		this.tempMin = entity.getTempMin();
		this.windDirection = entity.getWindDirection();
		this.windSpeed = entity.getWindSpeed();
		this.humidity = entity.getHumidity();
		this.pressure = entity.getPressure();
	}
	
	// getter setter
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getTempMax() {
		return tempMax;
	}
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
	public Double getTempMin() {
		return tempMin;
	}
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}
	public Integer getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}
	public Double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	
	
	

}
