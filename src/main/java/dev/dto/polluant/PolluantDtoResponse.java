package dev.dto.polluant;

import dev.dto.SuperDto;
import dev.entity.Polluant;

public class PolluantDtoResponse extends SuperDto {

	private Integer rate;
	private String dominentpol;
	private Double no2;
	private Double o3;
	private Double pm10;
	private Double pm25;
	
	//constructeur
	public PolluantDtoResponse(Polluant entity) {
		this.id=entity.getId();
		this.dateAdd=entity.getDateAdd();
		this.rate = entity.getRate();
		this.dominentpol = entity.getDominentpol();
		this.no2 = entity.getNo2();
		this.o3 = entity.getO3();
		this.pm10 = entity.getPm10();
		this.pm25 = entity.getPm25();
	}
	//getteur/setteur
	
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
