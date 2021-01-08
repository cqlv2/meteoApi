package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Polluant extends SuperEntity{
	
	private String nom;
	@Column(scale = 4, precision = 2)
	private Double valeur;
	
	@ManyToOne
	@JoinColumn(name = "ville_id")
	private City ville;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getValeur() {
		return valeur;
	}
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	public City getVille() {
		return ville;
	}
	public void setVille(City ville) {
		this.ville = ville;
	}
	
	

}
