package dev.dto;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SuperDto {

	protected Long id;
	protected LocalDate dateAdd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(LocalDate dateAdd) {
		this.dateAdd = dateAdd;
	}

}
