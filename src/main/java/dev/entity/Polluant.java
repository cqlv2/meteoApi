package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Polluant extends SuperEntity {

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	private Integer rate;
	private String dominentpol;
	@Column(precision = 10, scale = 1)
	private Double no2;
	@Column(precision = 10, scale = 1)
	private Double o3;
	@Column(precision = 10, scale = 1)
	private Double pm10;
	@Column(precision = 10, scale = 1)
	private Double pm25;

	// getteur/Setteur
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getDominentpol() {
		return dominentpol;
	}

	public void setDominentpol(String dominentpol) {
		this.dominentpol = dominentpol;
	}


	public Double getNo2() {
		return no2;
	}

	public void setNo2(Double no2) {
		this.no2 = no2;
	}

	public Double getO3() {
		return o3;
	}

	public void setO3(Double o3) {
		this.o3 = o3;
	}


	public Double getPm10() {
		return pm10;
	}

	public void setPm10(Double pm10) {
		this.pm10 = pm10;
	}

	public Double getPm25() {
		return pm25;
	}

	public void setPm25(Double pm25) {
		this.pm25 = pm25;
	}
}
