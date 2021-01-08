package dev.dto.city;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.polluant.PolluantDtoResponse;
import dev.dto.weather.WeatherDtoResponse;
import dev.entity.City;
import dev.entity.Polluant;
import dev.entity.Weather;
import dev.utils.transformer.PolluantTransformer;
import dev.utils.transformer.WeatherTransformer;

public class CityDtoResponse extends SuperDto{
	
	private String nomVille;
	private String codeInsee;
	private String codePostal;
	private Long nbHab;
	private String region;
	private List<WeatherDtoResponse> meteos = new ArrayList<>();
	private List<PolluantDtoResponse> polluants = new ArrayList<>();
	/**
	 * @param nomVille
	 * @param codeInsee
	 * @param codePostal
	 * @param nbHab
	 * @param region
	 * @param meteos
	 * @param polluants
	 */
	public CityDtoResponse(City entity) {
		this.id = entity.getId();
		this.nomVille = entity.getNomVille();
		this.codeInsee = entity.getCodeInsee();
		this.codePostal = entity.getCodePostal();
		this.nbHab = entity.getNbHab();
		this.region = entity.getRegion();
		
		for (Weather weather : entity.getMeteos()) {
			this.meteos.add(WeatherTransformer.entityToDtoResponse(weather));
		}

		for (Polluant polluant : entity.getPolluants()) {
			this.polluants.add(PolluantTransformer.entityToDtoResponse(polluant));
		}
		// getter setter
		
	
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getCodeInsee() {
		return codeInsee;
	}
	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Long getNbHab() {
		return nbHab;
	}
	public void setNbHab(Long nbHab) {
		this.nbHab = nbHab;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public List<WeatherDtoResponse> getMeteos() {
		return meteos;
	}
	public void setMeteos(List<WeatherDtoResponse> meteos) {
		this.meteos = meteos;
	}
	public List<PolluantDtoResponse> getPolluants() {
		return polluants;
	}
	public void setPolluants(List<PolluantDtoResponse> polluants) {
		this.polluants = polluants;
	}
	
	

}
