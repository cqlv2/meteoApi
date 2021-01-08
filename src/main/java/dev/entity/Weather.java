package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Weather extends SuperEntity {
	
	@Column(scale = 4, precision = 2)
	private Double temp;
	@Column(scale = 4, precision = 2)
	private Double tempMax;
	@Column(scale = 4, precision = 2)
	private Double tempMin;
	private Integer windDirection;
	@Column(scale = 4, precision = 2)
	private Double windSpeed;
	@Column(scale = 4, precision = 2)
	private Double humidity;
	@Column(scale = 4, precision = 2)
	private Double pressure;
	
	//TODO 
	//private Meteo prevision;
	
	@ManyToOne
	@JoinColumn(name = "ville_id")
	private Ville ville;
	
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
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
//	public Meteo getPrevision() {
//		return prevision;
//	}
//	public void setPrevision(Meteo prevision) {
//		this.prevision = prevision;
//	}
//	
	

}
