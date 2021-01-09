package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Polluant extends SuperEntity{
	
	private String label;
	@Column(scale = 4, precision = 2)
	private Double value;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	//getteur/setteur
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	

}
