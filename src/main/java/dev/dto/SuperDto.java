package dev.dto;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SuperDto {

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
