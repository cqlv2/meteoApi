package dev.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Favorite extends SuperEntity {
	
	
	private Boolean showWeather;
	private Boolean showPolluants;
	private String polluant;
	private String infoWeather;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Member member;	
	@OneToOne
	@JoinColumn( name="ville_id" )
	private City ville;
	//getteur/setteur
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public City getVille() {
		return ville;
	}
	public void setVille(City ville) {
		this.ville = ville;
	}
	
}
