package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class City extends SuperEntity {

	private String cityName;
	private String inseeCode;
	private Long population;
	private String state;
	private String department;

	@OneToMany(targetEntity = Weather.class, mappedBy = "city")
	private List<Weather> weathers = new ArrayList<>();

	@OneToMany(targetEntity = Polluant.class, mappedBy = "city")
	private List<Polluant> polluants = new ArrayList<>();
	// getteur setteur

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

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public List<Polluant> getPolluants() {
		return polluants;
	}

	public void setPolluants(List<Polluant> polluants) {
		this.polluants = polluants;
	}

}
