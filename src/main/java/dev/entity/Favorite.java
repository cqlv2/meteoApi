package dev.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dev.enumeration.PolluantEnum;
import dev.enumeration.WeatherEnum;

@Entity
public class Favorite extends SuperEntity {

	private Boolean showWeather;
	private Boolean showPolluants;
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private List<PolluantEnum> polluants;
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private List<WeatherEnum> infoWeather;
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	// getteur/setteur
	public Boolean getShowWeather() {
		return showWeather;
	}

	public void setShowWeather(Boolean showWeather) {
		this.showWeather = showWeather;
	}

	public Boolean getShowPolluants() {
		return showPolluants;
	}

	public void setShowPolluants(Boolean showPolluants) {
		this.showPolluants = showPolluants;
	}

	public List<PolluantEnum> getPolluants() {
		return polluants;
	}

	public void setPolluants(List<PolluantEnum> polluants) {
		this.polluants = polluants;
	}

	public List<WeatherEnum> getInfoWeather() {
		return infoWeather;
	}

	public void setInfoWeather(List<WeatherEnum> infoWeather) {
		this.infoWeather = infoWeather;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
