package dev.dto.city;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;


public class CityDtoQuery extends SuperDto {
	
	private String nomVille;
	private String codeInsee;
	private String codePostal;
	private Long nbHab;
	private String region;
	private List<Long> meteosId = new ArrayList<>();
	private List<Long> polluantsId = new ArrayList<>();
	//getter setter
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
	public List<Long> getMeteosId() {
		return meteosId;
	}
	public void setMeteosId(List<Long> meteosId) {
		this.meteosId = meteosId;
	}
	public List<Long> getPolluantsId() {
		return polluantsId;
	}
	public void setPolluantsId(List<Long> polluantsId) {
		this.polluantsId = polluantsId;
	}
	
	

}
