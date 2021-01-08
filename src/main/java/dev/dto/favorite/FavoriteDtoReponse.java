package dev.dto.favorite;

import java.util.List;

import dev.dto.SuperDto;
import dev.entity.Favorite;

public class FavoriteDtoReponse extends SuperDto{
	
	private Boolean showWeather;
	private Boolean showPolluants;
	private String polluant;
	private String infoWeather;

	// constructeur
	public FavoriteDtoReponse(Favorite entity) {
		this.id = entity.getId();
		this.showWeather = entity.getShowWeather();
		this.showPolluants = entity.getShowPolluants();
		this.polluant = entity.getPolluant();
		this.infoWeather = entity.getInfoWeather();
	}

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

}
