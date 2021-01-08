package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class City extends SuperEntity {

	private String nomVille;
	private String codeInsee;
	private String codePostal;
	private Long nbHab;
	private String region;
	
	@OneToMany(targetEntity = Weather.class, mappedBy = "ville")
	private List<Weather> meteos = new ArrayList<>();
	
	@OneToMany(targetEntity = Polluant.class, mappedBy = "ville")
	private List<Polluant> polluants = new ArrayList<>();
	
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
	public List<Weather> getMeteos() {
		return meteos;
	}
	public void setMeteos(List<Weather> meteos) {
		this.meteos = meteos;
	}
	public List<Polluant> getPolluants() {
		return polluants;
	}
	public void setPolluants(List<Polluant> polluants) {
		this.polluants = polluants;
	}
	
	
	
}
