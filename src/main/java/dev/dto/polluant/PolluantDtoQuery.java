package dev.dto.polluant;

import dev.dto.SuperDto;

public class PolluantDtoQuery extends SuperDto {

	private Long cityId;
	private Integer rate;
	private String dominentpol;
	private Double no2;
	private Double o3;
	private Double pm10;
	private Double pm25;

	// getteur/setteur
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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
