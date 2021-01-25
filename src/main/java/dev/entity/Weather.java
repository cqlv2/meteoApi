package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Weather extends SuperEntity {

	private String icone;
	private String label;
	private String description;

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
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	// getteurSetteur

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

//	public Meteo getPrevision() {
//		return prevision;
//	}
//	public void setPrevision(Meteo prevision) {
//		this.prevision = prevision;
//	}
//	

}
