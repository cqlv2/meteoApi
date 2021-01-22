package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class City extends SuperEntity {

	private String cityName;
	private String inseeCode;
	private Long population;
	private String state;
	private String department;
	private Double longitude;
	private Double latitude;

	
	@OneToOne( mappedBy = "city", cascade = CascadeType.REMOVE )
    private Favorite favorite;
	
	
	@OneToMany(targetEntity = Weather.class, mappedBy = "city", cascade = CascadeType.REMOVE)
	private List<Weather> weathers = new ArrayList<>();

	@OneToMany(targetEntity = Polluant.class, mappedBy = "city", cascade = CascadeType.REMOVE)
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

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
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
