package dev.dto.favorite;

import java.util.List;

import dev.dto.SuperDto;
import dev.dto.city.CityDtoResponse;
import dev.entity.Favorite;
import dev.enumeration.PolluantEnum;
import dev.enumeration.WeatherEnum;
import dev.utils.transformer.CityTransformer;

public class FavoriteDtoResponse extends SuperDto{
	
	private Boolean showWeather;
	private Boolean showPolluants;
	private List<PolluantEnum> polluants;
	private List<WeatherEnum> infoWeather;
	private CityDtoResponse cityDtoResponse;

	// constructeur
	public FavoriteDtoResponse(Favorite entity) {
		this.id = entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.showWeather = entity.getShowWeather();
		this.showPolluants = entity.getShowPolluants();
		this.polluants = entity.getPolluants();
		this.infoWeather = entity.getInfoWeather();
		this.cityDtoResponse = CityTransformer.entityToDtoResponse(entity.getCity());
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

	public List<PolluantEnum> getPolluants() {
		return polluants;
	}

	public void setPolluants(List<PolluantEnum> polluant) {
		this.polluants = polluant;
	}

	public List<WeatherEnum> getInfoWeather() {
		return infoWeather;
	}

	public void setInfoWeather(List<WeatherEnum> infoWeather) {
		this.infoWeather = infoWeather;
	}

	public CityDtoResponse getCityDtoResponse() {
		return cityDtoResponse;
	}

	public void setCityDtoResponse(CityDtoResponse cityDtoResponse) {
		this.cityDtoResponse = cityDtoResponse;
	}

}
