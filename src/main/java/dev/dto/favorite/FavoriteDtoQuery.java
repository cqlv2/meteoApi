package dev.dto.favorite;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;
import dev.entity.Member;
import dev.enumeration.PolluantEnum;
import dev.enumeration.WeatherEnum;
import dev.entity.City;
//exemple de json
//		{
//			"showWeather":0,
//			"showPolluants":0,
//			"polluant":["o3","no2"],
//			"infoWeather":["temp","windSpeed", "windDirection"],
//			"memberId":1,
//			"villeId":1
//		}

public class FavoriteDtoQuery extends SuperDto {


	private Boolean showWeather = true;
	private Boolean showPolluants = true;
	private List<PolluantEnum> polluants;
	private List<WeatherEnum> infoWeather;
	@NotNull
	private Long memberId;
	@NotNull
	private Long villeId;

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

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getVilleId() {
		return villeId;
	}

	public void setVilleId(Long villeId) {
		this.villeId = villeId;
	}
}
