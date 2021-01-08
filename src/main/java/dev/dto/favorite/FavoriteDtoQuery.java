package dev.dto.favorite;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import dev.dto.SuperDto;
import dev.entity.Member;
import dev.entity.Ville;
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

	private Boolean showWeather;
	private Boolean showPolluants;
	private String polluant;
	private String infoWeather;
	private Long memberId;
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

	public String getPolluant() {
		return polluant;
	}

	public void setPolluant(String polluant) {
		this.polluant = polluant;
	}

	public String getInfoWeather() {
		return infoWeather;
	}

	public void setInfoWeather(String infoWeather) {
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
